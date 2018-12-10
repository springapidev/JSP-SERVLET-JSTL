package com.apress.projsp;

import net.sf.flock.FeedI;
import net.sf.flock.parser.FlockFeedFactory;
import net.sf.flock.ItemI;
import java.net.URL;
import java.util.Iterator;
import com.apress.projsp.persist.*;

public class AggregatorImpl implements Aggregator {
  private AggregatorDAO dao;

  public AggregatorImpl(AggregatorDAO dao) {
    this.dao = dao;
  }

  /** Run aggregation, collection items, store them in database */
  public void aggregate() throws Exception {
    FlockFeedFactory factory = new FlockFeedFactory();
    Iterator feedIter = dao.getAllNewsfeeds().iterator();
    while (feedIter.hasNext()) {
      Newsfeed feed = (Newsfeed) feedIter.next();
      String url = feed.getUrl();
      try {
        FeedI flockFeed = factory.loadFeed(new URL(url));
        Iterator articleIter = flockFeed.getItems().iterator();
        while (articleIter.hasNext()) {
          ItemI article = (ItemI) articleIter.next();
          Item item = new Item(article.getTitle(), article.getCreationTime(),
              article.getLink().toString(), article.getDescription(), "");
          dao.addItem(feed, item);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /** Gets user by name, create new user if necessary. */
  public User getUser(String userName) throws Exception {
    return dao.getUser(userName);
  }

  /**
   * Add new subscription and associate with a newsfeed, creating a new newsfeed
   * only if necessary.
   */
  public Subscription addSubscription(User user, String name, String url)
      throws Exception {
    return dao.addSubscription(user, name, url);
  }

  /**
   * Remove subscription but not associated Newsfeed.
   */
  public void removeSubscription(String id) throws Exception {
    Subscription sub = dao.retrieveSubscription(id);
    dao.removeSubscription(sub);
  }
}