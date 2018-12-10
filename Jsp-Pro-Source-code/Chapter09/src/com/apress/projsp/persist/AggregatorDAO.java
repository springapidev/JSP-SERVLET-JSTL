package com.apress.projsp.persist;

import com.apress.projsp.Item;
import com.apress.projsp.Newsfeed;
import com.apress.projsp.Subscription;
import com.apress.projsp.User;
import java.util.List;

/** Aggregator Data Access Object (DAO) interface. */
public interface AggregatorDAO {
  /** Gets user by name, create new user if necessary. */
  public User getUser(String userName) throws DAOException;

  /** Add new subscription and associate with a newsfeed */
  public Subscription addSubscription(User user, String name, String url)
      throws DAOException;

  /** Retrieve subscription by ID */
  public Subscription retrieveSubscription(String id) throws DAOException;

  /** Remove subscription but not associated Newsfeed. */
  public void removeSubscription(Subscription sub) throws DAOException;

  /** Get all newsfeeds. */
  public List getAllNewsfeeds() throws DAOException;

  /** Remove newsfeed and associated subscriptions. */
  public void removeNewsfeed(Newsfeed feed) throws DAOException;

  /** Store newsfeed. */
  public void storeNewsfeed(Newsfeed feed) throws DAOException;

  /** Add item to newsfeed. */
  public void addItem(Newsfeed feed, Item item) throws DAOException;

  /** Add a newsfeed (for testing only). */
  public Newsfeed addNewsfeed(String url) throws DAOException;

  /** Get all items (for testing only). */
  public List getAllItems() throws DAOException;
}