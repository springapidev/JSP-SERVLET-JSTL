package com.apress.projsp;


//import ag.persist.AggregatorDAO;
import java.util.Date;
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
    private String mName;
    private Set mSubscriptions = new HashSet();
    private Set mItems = new TreeSet();
    private Date mUpdated = new Date();

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
    
    /**
     * Returns the time.
     * @return Date
     * @castor:field set-method="setUpdated" required="true"
     * @castor:field-sql name="updated" sql-dirty="ignore" dirty="true" type="timestamp"
     */
    public Date getUpdated() {
        return mUpdated;
    }

    /**
     * Sets the time.
     * @param time The time to set
     */
    public void setUpdated(Date time) {
        mUpdated = time;
    }
    

	/**
     * Get the name.
     * @castor:field set-method="setName" required="true"
     * @castor:field-sql name="name" sql-dirty="ignore" dirty="true" type="string"
	 */
	public String getName() {
		return mName;
	}

	/**
     * Set the name.
	 * @param string
	 */
	public void setName(String string) {
		mName = string;
	}

    public String toString() {
		return mName;
	}
}
