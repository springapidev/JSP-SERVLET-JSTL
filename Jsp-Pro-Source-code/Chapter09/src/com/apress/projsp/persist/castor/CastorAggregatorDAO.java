package com.apress.projsp.persist.castor;

import com.apress.projsp.Item;
import com.apress.projsp.Newsfeed;
import com.apress.projsp.Subscription;
import com.apress.projsp.User;
import com.apress.projsp.persist.AggregatorDAO;
import com.apress.projsp.persist.DAOException;

import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.JDO;
import org.exolab.castor.jdo.OQLQuery;
import org.exolab.castor.jdo.QueryResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/////////////////////////////////////////////////////////////////////////////

/**
 * Alternative: Castor implementation of Ag DAO.
 */
public class CastorAggregatorDAO implements AggregatorDAO {
    protected transient JDO mJDO = null;

    public CastorAggregatorDAO(String config) throws DAOException {
        try {
            mJDO = new JDO();
            mJDO.setDatabaseName("agdb");
            JDO.loadConfiguration(config);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    //-------------------------------------------------------- Users

    /**
     * @see com.apress.projsp.AggregatorDAO#getUser(String)
     */
    public User getUser(String name) throws DAOException {
        User user = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            OQLQuery oql = db.getOQLQuery(
                    "SELECT p FROM com.apress.projsp.User p WHERE name=$1");
            oql.bind(name);

            QueryResults results = oql.execute();

            while (results.hasMore()) {
                user = (User) results.next();

                break;
            }

            if (user == null) {
                user = new User(name);
                db.create(user);
            }

            user = (User) db.load(com.apress.projsp.User.class,
                    user.getId());

            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return user;
    }

    //-------------------------------------------------------- Subscriptions

    /**
     * @see com.apress.projsp.AggregatorDAO#addSubscription(User, String, String)
     */
    public Subscription addSubscription(User user, String name, String url)
        throws DAOException {
        Subscription sub = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            sub = new Subscription(name, url);

            // User must originate within this session
            user = (User) db.load(com.apress.projsp.User.class,
                    user.getId());

            // Find subscription's newsfeed object
            Newsfeed feed = null;
            OQLQuery oql = db.getOQLQuery(
                    "SELECT feed FROM com.apress.projsp.Newsfeed feed WHERE url=$1");
            oql.bind(url);

            QueryResults results = oql.execute();

            while (results.hasMore()) {
                feed = (Newsfeed) results.next();

                break;
            }

            // If not found then create new newsfeed
            if (feed == null) {
                feed = new Newsfeed(url);
                db.create(feed);
            }

            sub.setUser(user);
            sub.setNewsfeed(feed);
            db.create(sub);

            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return sub;
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#removeSubscription(Subscription)
     */
    public void removeSubscription(Subscription sub) throws DAOException {
        removeObject(sub, com.apress.projsp.Subscription.class,
            sub.getId());
    }

	/**
	 * @see com.apress.projsp.AggregatorDAO#removeItem(Item)
	 */
	public void removeItem(Item item) throws DAOException {
		removeObject(item, Item.class, item.getId());
	}

    /**
     * @see com.apress.projsp.AggregatorDAO#retrieveSubscription(String)
     */
    public Subscription retrieveSubscription(String id)
        throws DAOException {
        return (Subscription) retrieveObject(com.apress.projsp.Subscription.class,
            id);
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#storeSubscription(Subscription)
     */
    public void storeSubscription(Subscription sub) throws DAOException {
        createObject(sub);
    }

    //------------------------------------------------------------ Newsfeeds

    /**
     * @see com.apress.projsp.AggregatorDAO#getAllNewsfeeds()
     */
    public List getAllNewsfeeds() throws DAOException {
        ArrayList feeds = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            OQLQuery oql = db.getOQLQuery("SELECT feed FROM com.apress.projsp.Newsfeed feed");
            QueryResults results = oql.execute();
            feeds = new ArrayList(Collections.list(results));
            db.commit();
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return feeds;
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#getNewsfeed(String)
     */
    public Newsfeed getNewsfeed(String url) throws DAOException {
        Newsfeed feed = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            // Find subscription's newsfeed object
            OQLQuery oql = db.getOQLQuery(
                    "SELECT feed FROM com.apress.projsp.Newsfeed feed WHERE url=$1");
            oql.bind(url);

            QueryResults results = oql.execute();

            while (results.hasMore()) {
                feed = (Newsfeed) results.next();

                break;
            }

            db.commit();
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return feed;
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#removeNewsfeed(String)
     */
    public void removeNewsfeed(Newsfeed feed) throws DAOException {
        // if cascade worked, we could just do this
        //removeObject(feed); 
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            // Newsfeed must originate within this session
            feed = (Newsfeed) db.load(com.apress.projsp.Newsfeed.class,
                    feed.getId());

            OQLQuery oql = db.getOQLQuery(
                    "SELECT sub FROM com.apress.projsp.Subscription sub WHERE newsfeed=$1");
            oql.bind(feed);

            QueryResults results = oql.execute();

            while (results.hasMore()) {
                db.remove(results.next());
            }

            oql = db.getOQLQuery(
                    "SELECT item FROM com.apress.projsp.Item item WHERE newsfeed=$1");
            oql.bind(feed);
            results = oql.execute();

            while (results.hasMore()) {
                db.remove(results.next());
            }

            db.remove(feed);

            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#retrieveNewsfeed(String)
     */
    public Newsfeed retrieveNewsfeed(String id) throws DAOException {
        return (Newsfeed) retrieveObject(com.apress.projsp.Newsfeed.class,
            id);
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#storeNewsfeed(Newsfeed)
     */
    public void storeNewsfeed(Newsfeed feed) throws DAOException {
        createObject(feed);
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#addItem(Newsfeed, Item)
     */
    public void addItem(Newsfeed feed, Item item) throws DAOException {
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            // Newsfeed must originate within this session
            feed = (Newsfeed) db.load(com.apress.projsp.Newsfeed.class,
                    feed.getId());

            item.setNewsfeed(feed);
            db.create(item);

            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }
    }

    //----------------------------------------------------------- Testing 

    /**
     * @see com.apress.projsp.AggregatorDAO#addNewsfeed(String)
     */
    public Newsfeed addNewsfeed(String url) throws DAOException {
        Newsfeed feed = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();
            feed = new Newsfeed(url);
            db.create(feed);
            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return feed;
    }

    /**
     * @see com.apress.projsp.AggregatorDAO#getAllItems()
     */
    public List getAllItems() throws DAOException {
        ArrayList items = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();

            OQLQuery oql = db.getOQLQuery("SELECT item FROM com.apress.projsp.Item item");
            QueryResults results = oql.execute();
            items = new ArrayList(Collections.list(results));
            db.commit();
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return items;
    }

    //----------------------------------------------------------- Privates   

    /**
     *
     */
    private void removeObject(Object obj, Class clazz, String id)
        throws DAOException {
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();
            obj = db.load(clazz, id, obj);
            db.remove(obj);
            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }
    }

    /**
     *
     */
    private Object retrieveObject(Class clazz, String id)
        throws DAOException {
        Object obj = null;
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();
            obj = db.load(clazz, id);
            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }

        return obj;
    }

    /**
     *
     */
    private void createObject(Object obj) throws DAOException {
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();
            db.create(obj);
            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }
    }

    /**
     *
     */
    private void updateObject(Object obj, Class clazz, String id)
        throws DAOException {
        Database db = null;

        try {
            db = mJDO.getDatabase();
            db.begin();
            obj = db.load(clazz, id, obj);
            db.update(obj);
            db.commit();
        }
        catch (Exception e) {
            try {
                db.rollback();
            }
            catch (Exception ex) {
                e.printStackTrace();
            }

            ;
            throw new DAOException(e);
        }
        finally {
            try {
                db.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            ;
        }
    }

    /* (non-Javadoc)
     * @see com.apress.projsp.persist.AggregatorDAO#removeItem(java.lang.String)
     */
    public void removeItem(String id)
    {
        // TODO Auto-generated method stub
        
    }
}
