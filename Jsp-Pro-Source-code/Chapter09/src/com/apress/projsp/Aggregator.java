package com.apress.projsp;

/**
 * Business interface for Newsfeed aggregation.
 */
public interface Aggregator {
  /** Gets user by name, create new user if necessary. */
  public User getUser(String userName) throws Exception;

  /** Add new subscription and associate with a newsfeed. */
  public Subscription addSubscription(User user, String name, String url)
      throws Exception;

  /** Remove subscription by id. */
  public void removeSubscription(String id) throws Exception;

  /** Run the aggregator and fetch items from all Newsfeeds. */
  public void aggregate() throws Exception;
}