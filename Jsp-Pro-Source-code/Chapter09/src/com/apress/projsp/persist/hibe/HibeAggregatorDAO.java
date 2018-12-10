package com.apress.projsp.persist.hibe;

import com.apress.projsp.Item;
import com.apress.projsp.Newsfeed;
import com.apress.projsp.Subscription;
import com.apress.projsp.User;
import com.apress.projsp.persist.AggregatorDAO;
import com.apress.projsp.persist.DAOException;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.*;

/** Hibernate implementation of Ag DAO. */
public class HibeAggregatorDAO implements AggregatorDAO
{
  private static SessionFactory sessionFactory;

  public HibeAggregatorDAO() throws DAOException {
    try {
      Configuration config = new Configuration();
      config.addClass(Newsfeed.class);
      config.addClass(Subscription.class);
      config.addClass(User.class);
      config.addClass(Item.class);
      sessionFactory = config.buildSessionFactory();
    } catch (MappingException e) {
      e.printStackTrace();
      throw new DAOException(e);
    } catch (HibernateException e) {
      e.printStackTrace();
      throw new DAOException(e);
    }
  }

  // -------------------------------------------------------- Users

  /** Get user by name, create new one if necessary. */
  public User getUser(String name) throws DAOException {
    User user = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      String userQuery = "from user in class com.apress.projsp.User where name=?";
      Query query = ses.createQuery(userQuery);
      query.setString(0, name);

      List users = query.list();

      if ((users != null) && (users.size() > 0)) {
        user = (User) users.get(0);
      }

      if (user == null) {
        user = new User(name);
        String id = (String) ses.save(user);
      }

      user = (User) ses.load(User.class, user.getId());
      Set subs = user.getSubscriptions();
      loadSubscriptions(subs);
      
      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return user;
  }

  private void loadSubscriptions(Collection allSubs) {
    Hibernate.initialize(allSubs);
    Iterator subs = allSubs.iterator();
    while (subs.hasNext()) {
      Subscription sub = (Subscription) subs.next();
      Newsfeed feed = sub.getNewsfeed();
      System.out.println("initializing feed "+feed.getUrl());
      loadNewsfeeds(feed);
    }
  }
  
  private void loadNewsfeeds(Newsfeed feed) {
    Hibernate.initialize(feed);
    Set items = feed.getItems();
    Hibernate.initialize(items);
    Iterator newsItems = items.iterator();
    while (newsItems.hasNext()) {
      Item item = (Item) newsItems.next();
      Hibernate.initialize(item);
    }
  }

  // --------------------------------------------------------
  // Subscriptions

  /**
   * @see com.apress.projsp.AggregatorDAO#addSubscription(String,
   *      String)
   */
  public Subscription addSubscription(User user, String name, String url)
      throws DAOException
  {
    Subscription sub = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();

      sub = new Subscription(name, url);

      // User must originate within this session
      user = (User) ses.load(User.class, user.getId());

      // Find subscription's newsfeed object
      Newsfeed feed = null;
      String feedQuery = "from feed in class com.apress.projsp.Newsfeed where feed.url=?";
      Query query = ses.createQuery(feedQuery);
      query.setString(0, url);
      List feeds = query.list();

      if ((feeds != null) && (feeds.size() > 0)) {
        feed = (Newsfeed) feeds.get(0);
      }

      // If not found then create new newsfeed
      if (feed == null) {
        feed = new Newsfeed(url);
        ses.save(feed);
      }

      sub.setUser(user);
      sub.setNewsfeed(feed);
      feed.getSubscriptions().add(sub);
      ses.save(sub);

      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return sub;
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#removeSubscription(String)
   */
  public void removeSubscription(Subscription sub) throws DAOException {
    removeObject(Subscription.class, sub.getId());
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#retrieveSubscription(String)
   */
  public Subscription retrieveSubscription(String id)
      throws DAOException
  {
    return (Subscription) retrieveObject(Subscription.class, id);
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#storeSubscription(Subscription)
   */
  public void storeSubscription(Subscription sub) throws DAOException {
    storeObject(sub);
  }

  // ------------------------------------------------------------
  // Newsfeeds

  /**
   * @see com.apress.projsp.AggregatorDAO#getAllNewsfeeds(String)
   */
  public List getAllNewsfeeds() throws DAOException {
    List feeds = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      String newsfeedQuery = "from newsfeed in class com.apress.projsp.Newsfeed";
      Query query = ses.createQuery(newsfeedQuery);
      feeds = query.list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return feeds;
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#removeItem(Item)
   */
  public void removeItem(Item item) throws DAOException {
    removeObject(Item.class, item.getId());
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#removeNewsfeed(Newsfeed)
   */
  public void removeNewsfeed(Newsfeed feed) throws DAOException {
    removeObject(Newsfeed.class, feed.getId());

    /*
     * This might be necessary on MySQL so I'm keeping it around
     * 
     * Session ses = null; try { ses = sessionFactory.openSession();
     * 
     * ses.delete( "select newsfeed.subscriptions.elements " +"from
     * newsfeed in class com.apress.projsp.Newsfeed where newsfeed = ?",
     * feed, Hibernate.association(com.apress.projsp.Newsfeed.class) );
     * 
     * ses.delete( "select newsfeed.items.elements " +"from newsfeed in
     * class com.apress.projsp.Newsfeed where newsfeed = ?", feed,
     * Hibernate.association(com.apress.projsp.Newsfeed.class) );
     * 
     * ses.delete( feed );
     * 
     * ses.flush(); ses.connection().commit(); } catch (Exception e) {
     * try { ses.connection().rollback(); } catch (Exception ex) {
     * e.printStackTrace(); }; throw new DAOException(e); } finally {
     * try { ses.close(); } catch (Exception ex) { ex.printStackTrace(); }; }
     */
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#retrieveNewsfeed(String)
   */
  public Newsfeed retrieveNewsfeed(String id) throws DAOException {
    return (Newsfeed) retrieveObject(Newsfeed.class, id);
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#storeNewsfeed(Newsfeed)
   */
  public void storeNewsfeed(Newsfeed feed) throws DAOException {
    storeObject(feed);
  }

  /**
   * Add item to newsfeed.
   */
  public void addItem(Newsfeed feed, Item item) throws DAOException {
    Session ses = null;

    try {
      ses = sessionFactory.openSession();

      // Feed must originate in this session
      feed = (Newsfeed) ses.load(Newsfeed.class, feed.getId());

      feed.getItems().add(item);
      item.setNewsfeed(feed);
      ses.save(item);

      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }
  }

  // -----------------------------------------------------------
  // Privates

  /**
   * 
   */
  private void removeObject(Class clazz, String id) throws DAOException
  {
    Session ses = null;

    try {
      ses = sessionFactory.openSession();

      // Object must originate in this session
      Object obj = ses.load(clazz, id);

      ses.delete(obj);
      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }
  }

  /**
   * 
   */
  private Object retrieveObject(Class clazz, String id)
      throws DAOException
  {
    Object obj = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      obj = ses.load(clazz, id);
    } catch (Exception e) {
      e.printStackTrace();
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return obj;
  }

  /**
   * 
   */
  private void storeObject(Object obj) throws DAOException {
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      ses.saveOrUpdate(obj);
      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }
  }

  // ----------------------------------------------------------- Testing

  /**
   * Add a newsfeed (only for testing).
   */
  public Newsfeed addNewsfeed(String url) throws DAOException {
    Newsfeed feed = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      feed = new Newsfeed(url);
      ses.save(feed);
      ses.flush();
      ses.connection().commit();
    } catch (Exception e) {
      e.printStackTrace();
      rollback(ses);
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return feed;
  }

  /**
   * @see com.apress.projsp.AggregatorDAO#getAllItems(String)
   */
  public List getAllItems() throws DAOException {
    List items = null;
    Session ses = null;

    try {
      ses = sessionFactory.openSession();
      String itemQuery = "from item in class com.apress.projsp.Item";
      Query query = ses.createQuery(itemQuery);
      items = query.list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new DAOException(e);
    } finally {
      close(ses);
    }

    return items;
  }

  private void close(Session session) {
    try {
      session.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void rollback(Session session) {
    try {
      session.connection().rollback();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
