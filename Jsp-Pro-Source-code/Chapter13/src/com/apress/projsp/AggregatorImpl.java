package com.apress.projsp;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import net.sf.flock.*;
import net.sf.flock.parser.FlockFeedFactory;

import com.apress.projsp.persist.AggregatorDAO;

/**
 * Business tier implementation. Uses Flock to parse RSS news feeds and
 * uses DAO interface to access database.
 */
public class AggregatorImpl implements Aggregator
{
  private AggregatorDAO mDAO;

  public AggregatorImpl(AggregatorDAO dao) {
    mDAO = dao;
  }

  /** Gets user by name, create new user if necessary. */
  public User getUser(String userName) throws Exception {
    return mDAO.getUser(userName);
  }

  /**
   * Add new subscription and associate with a newsfeed, creating a new
   * newsfeed only if necessary.
   */
  public Subscription addSubscription(User user, String name, String url)
      throws Exception
  {
    return mDAO.addSubscription(user, name, url);
  }

  /**
   * Remove subscription but not associated Newsfeed.
   */
  public void removeSubscription(String id) throws Exception {
    Subscription sub = mDAO.retrieveSubscription(id);
    mDAO.removeSubscription(sub);
  }

  /** Run aggregation, collection items, store them in database */
  public void aggregate() throws Exception {

    // Clear all news items
    Iterator itemIter = mDAO.getAllItems().iterator();
    while (itemIter.hasNext()) {
      Item item = (Item) itemIter.next();
      mDAO.removeItem(item);
    }

    // Fetch, parse, and store items from all feeds
    FlockFeedFactory factory = new FlockFeedFactory();
    Iterator feedIter = mDAO.getAllNewsfeeds().iterator();
    while (feedIter.hasNext()) {
      Newsfeed feed = (Newsfeed) feedIter.next();

      String url = feed.getUrl();

      try {
        FeedI flockFeed = factory.loadFeed(new URL(url));
        Iterator items = flockFeed.getItems().iterator();

        while (items.hasNext()) {
          ItemI article = (ItemI) items.next();
          Item item = new Item(article.getTitle(), article
              .getCreationTime(), article.getLink().toString(), article
              .getDescription(), "", 0);
          mDAO.addItem(feed, item);
        }

        mDAO.updateNewsfeed(feed, flockFeed.getTitle());
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
  }

  /**
   * Get recent newsfeed items.
   */
  public List getRecentItems() throws Exception {
    return mDAO.getRecentItems();
  }

  /**
   * Get popular newsfeed items.
   */
  public List getPopularItems() throws Exception {
    return mDAO.getPopularItems();
  }

  /**
   * Get recently updated newsfeeds.
   */
  public List getRecentyUpdatedNewsfeeds() throws Exception {
    return mDAO.getRecentlyUpdatedNewsfeeds();
  }

  /**
   * Record a hit for item specified by permalink
   */
  public void hitItem(String link) throws Exception {
    mDAO.hitItem(link);
  }

}
