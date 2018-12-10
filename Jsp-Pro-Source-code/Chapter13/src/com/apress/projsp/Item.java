package com.apress.projsp;

import java.util.Date;


/**
 * Represents a single news item retrieved from a newsfeed.
 * @castor:class name="Item" table="item" id="id"
 * key-generator="UUID" auto-complete="true"
 */
public class Item {
    private String mId;
    private String mLink;
    private String mDescription;
    private String mContent;
    private String mTitle;
    private int mHits = 0;
    private Date mTime = new Date();
    private Newsfeed mNewsfeed;

    /** Default constructor */
    public Item() {
    }

    /**
     * Construct Item using all field values.
     * @param title   Title of this news item.
     * @param time    Time of publication.
     * @param link    Link article on originating website.
     * @param desc    Description of article (or full text of article).
     * @param content (Optional) full text of article.
     */
    public Item(String title, Date time, String link, String description,
        String content, int hits) {
        mTitle = title;
        mTime = time;
        mLink = link;
        mDescription = description;
        mContent = content;
        mHits = hits;
    }

    /**
     * ID of the Item.
     * @return String
     * @castor:field set-method="setId" required="true"
     * @castor:field-sql name="id" sql-dirty="check" dirty="true"
     */
    public String getId() {
        return mId;
    }

    /**
     * ID of the Item.
     * @param id The id to set
     */
    public void setId(String id) {
        mId = id;
    }

    /**
     * Newsfeed from which this item was retrieved.
     * @return Newsfeed
     * @castor:field set-method="setNewsfeed" required="true" type="ag.Newsfeed"
     * @castor:field-sql name="newsfeed_id" sql-dirty="check" dirty="true"
     */
    public Newsfeed getNewsfeed() {
        return mNewsfeed;
    }

    /**
     * Newsfeed from which this item was retrieved.
     * @param newsfeed The newsfeed to set
     */
    public void setNewsfeed(Newsfeed newsfeed) {
        mNewsfeed = newsfeed;
    }

    /**
     * Returns the title.
     * @return String
     * @castor:field set-method="setTitle" required="true"
     * @castor:field-sql name="title" sql-dirty="check" dirty="true"
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Sets the title.
     * @param title The title to set
     */
    public void setTitle(String title) {
        mTitle = title;
    }

    /**
     * Returns the content.
     * @return String
    * @castor:field set-method="setContent" required="true"
    * @castor:field-sql name="content" sql-dirty="check" dirty="true"
     */
    public String getContent() {
        return mContent;
    }

    /**
     * Sets the content.
     * @param content The content to set
     */
    public void setContent(String content) {
        mContent = content;
    }

    /**
     * Returns the description.
     * @return String
    * @castor:field set-method="setDescription" required="true"
    * @castor:field-sql name="description" sql-dirty="check" dirty="true"
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Sets the description.
     * @param description The description to set
     */
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * Returns the link.
     * @return String
     * @castor:field set-method="setLink" required="true"
     * @castor:field-sql name="link" sql-dirty="check" dirty="true"
     */
    public String getLink() {
        return mLink;
    }

    /**
     * Sets the link.
     * @param link The link to set
     */
    public void setLink(String link) {
        mLink = link;
    }

    /**
     * Returns the time.
     * @return Date
     * @castor:field set-method="setTime" required="true"
     * @castor:field-sql name="time" sql-dirty="ignore" dirty="true" type="timestamp"
     */
    public Date getTime() {
        return mTime;
    }

    /**
     * Sets the time.
     * @param time The time to set
     */
    public void setTime(Date time) {
        mTime = time;
    }
    
	/**
     * Gets the hit count.
	 * @return Hit count.
     * 
     * @castor:field set-method="setHits" required="true"
     * @castor:field-sql name="hits" sql-dirty="ignore" dirty="true" type="integer"
	 */
	public int getHits() {
		return mHits;
	}

	/**
     * Sets the hit count.
	 * @param hits Hit count.
	 */
	public void setHits(int hits) {
		mHits = hits;
	}

}
