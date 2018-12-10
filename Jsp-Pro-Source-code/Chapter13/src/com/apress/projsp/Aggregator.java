package com.apress.projsp;

import java.util.List;


/**
 * Business interace for aggregation.
 */
public interface Aggregator {
    
    /** Gets user by name, create new user if necessary. */
    public User getUser(String userName) throws Exception;

    /** Add new subscription and associate with a newsfeed */
    public Subscription addSubscription(User user, String name, String url)
        throws Exception;

    /** Remove subscription by id. */
    public void removeSubscription(String id) throws Exception;

    /** Run the aggregator and fetch items from all Newsfeeds. */
    public void aggregate() throws Exception;
    
    /** Get most recent newsfeed items in the database */
    public List getRecentItems() throws Exception;

    /** Get most popular newsfeed items in the database */
    public List getPopularItems() throws Exception;

    /** Get most recently updated newsfeeds in the database */
    public List getRecentyUpdatedNewsfeeds() throws Exception;

    /** Record a hit for item specified by permalink */
	public void hitItem(String link) throws Exception;
}
