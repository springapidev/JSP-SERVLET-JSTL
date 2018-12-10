package com.apress.projsp;

import java.util.Date;

/**
 * Represents a single news item retrieved from a newsfeed.
 */
public class Item {
  private String mId;
  private String mLink;
  private String mDescription;
  private String mContent;
  private String mTitle;
  private Date mTime;
  private Newsfeed mNewsfeed;
  private Item mItem;

  /**
   * Construct Item using all field values.
   * 
   * @param title
   *          Title of this news item.
   * @param time
   *          Time of publication.
   * @param link
   *          Link article on originating website.
   * @param desc
   *          Description of article (or full text of article).
   * @param content
   *          (Optional) full text of article.
   */
  public Item(String title, Date time, String link, String description,
      String content) {
    mTitle = title;
    mTime = time;
    mLink = link;
    mDescription = description;
    mContent = content;
  }

  /** Default constructor */
  public Item() {
  }

  public String getId() {
    return mId;
  }

  public void setId(String id) {
    mId = id;
  }

  public Newsfeed getNewsfeed() {
    return mNewsfeed;
  }

  public void setNewsfeed(Newsfeed newsfeed) {
    mNewsfeed = newsfeed;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public String getContent() {
    return mContent;
  }

  public void setContent(String content) {
    mContent = content;
  }

  public String getDescription() {
    return mDescription;
  }

  public void setDescription(String description) {
    mDescription = description;
  }

  public String getLink() {
    return mLink;
  }

  public void setLink(String link) {
    mLink = link;
  }

  public Date getTime() {
    return mTime;
  }

  public void setTime(Date time) {
    mTime = time;
  }
}