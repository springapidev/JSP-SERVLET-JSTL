package com.apress.projsp.persist;

import com.apress.projsp.Item;
import com.apress.projsp.Newsfeed;
import com.apress.projsp.Subscription;
import com.apress.projsp.User;

import java.util.List;


/////////////////////////////////////////////////////////////////////////////

/**
 * Aggregator Data Access Object (DAO) interface.
 */
public interface AggregatorDAO {

    /** Add item to newsfeed. */
    public void addItem(Newsfeed feed, Item item) throws DAOException;

    /** Add a newsfeed (for testing only). */
    public Newsfeed addNewsfeed(String url) throws DAOException;

    /** Add new subscription and associate with a newsfeed */
    public Subscription addSubscription(User user, String name, String url)
        throws DAOException;

    /** Get all items. */
    public List getAllItems() throws DAOException;

    /** Get all newsfeeds. */
    public List getAllNewsfeeds() throws DAOException;
	
    /** Gets user by name, create new user if necessary. */
    public User getUser(String userName) throws DAOException;

	/** Remove item by id */
	public void removeItem(Item item) throws DAOException;

    /** Remove newsfeed and associated subscriptions.*/
    public void removeNewsfeed(Newsfeed feed) throws DAOException;

    /** Remove subscription but not associated Newsfeed. */
    public void removeSubscription(Subscription sub) throws DAOException;

    /** Retrieve subscription by ID */
    public Subscription retrieveSubscription(String id)
        throws DAOException;

    /** Store newsfeed. */
    public void storeNewsfeed(Newsfeed feed) throws DAOException;

	/** Set last update time for a newsfeed. */
	public void updateNewsfeed(Newsfeed feed, String title) throws DAOException;

	/** Get most popular items, order by descending hit count */
	public List getPopularItems() throws DAOException;

	/** Get most recently updated newsfeeds */
	public List getRecentlyUpdatedNewsfeeds() throws DAOException;

    /** Return 'count' most recent newfeed items */
    public List getRecentItems() throws DAOException;
    
    /** Record a hit for item specified by permalink */
	public void hitItem(String link) throws DAOException;
}
