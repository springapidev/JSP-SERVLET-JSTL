package com.apress.projsp;


//import ag.persist.AggregatorDAO;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author dmj
 * @castor:class name="Newsfeed" table="newsfeed" id="id"
 *  key-generator="UUID" auto-complete="true"
 */
public class Newsfeed {
    private String mUrl;
    private String mId;
    private Set mSubscriptions = new HashSet();
    private Set mItems = new TreeSet();

    public Newsfeed() {
    }

    public Newsfeed(String url) {
        mUrl = url;
    }

    /**
     * Returns the iD.
     * @castor:field set-method="setId" required="true"
     * @castor:field-sql name="id" sql-dirty="check" dirty="true"
     * @return String
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the iD.
     * @param iD The iD to set
     */
    public void setId(String id) {
        mId = id;
    }

    /**
     * Returns the items.
     * @castor:field set-method="setItems" type="ag.Item"
     *      required="true" collection="set"
     * @castor:field-sql many-table="item"
     *      many-key="newsfeed_id" sql-dirty="check" dirty="true"
     * @return Set
     */
    public Set getItems() {
        return mItems;
    }

    /**
     * Sets the items.
     * @param items The items to set
     */
    public void setItems(Set items) {
        mItems = items;
    }

    /**
     * Returns the subscriptions.
     * @castor:field set-method="setSubscriptions" type="ag.Subscription"
     *      required="true" collection="set"
     * @castor:field-sql many-table="subscription"
     *      many-key="newsfeed_id" sql-dirty="check" dirty="true"
     * @return Set
     */
    public Set getSubscriptions() {
        return mSubscriptions;
    }

    /**
     * Sets the subscriptions.
     * @param subscriptions The subscriptions to set
     */
    public void setSubscriptions(Set subscriptions) {
        mSubscriptions = subscriptions;
    }

    /**
     * Returns the url.
     * @castor:field set-method="setUrl" required="true"
     * @castor:field-sql name="url" sql-dirty="check" dirty="true"
     * @return String
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Sets the url.
     * @param url The url to set
     */
    public void setUrl(String url) {
        mUrl = url;
    }
}
