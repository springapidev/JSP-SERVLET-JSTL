package com.apress.projsp;


//import ag.persist.AggregatorDAO;

/**
 * @author dmj
 * @castor:class name="Subscription" table="subscription" id="id"
 *  key-generator="UUID" auto-complete="true"
 */
public class Subscription {
    private String mId;
    private String mName;
    private Newsfeed mNewsfeed;
    private User mUser;

    public Subscription() {
    }

    public Subscription(String name, String url) {
        mName = name;
    }

    /**
     * Returns the id.
     * @return String
     * @castor:field set-method="setId" required="true"
     * @castor:field-sql name="id" sql-dirty="check" dirty="true"
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the id.
     * @param id The id to set
     */
    public void setId(String id) {
        mId = id;
    }

    /**
     * Returns the name.
     * @return String
     * @castor:field set-method="setName" required="true"
     * @castor:field-sql name="name" sql-dirty="check" dirty="true"
     */
    public String getName() {
        return mName;
    }

    /**
    * Sets the name.
    * @param name The name to set
    */
    public void setName(String name) {
        mName = name;
    }

    /**
      * Returns the user.
      * @return User
      * @castor:field set-method="setUser" required="true" type="ag.User"
      * @castor:field-sql name="user_id" sql-dirty="check" dirty="true"
      */
    public User getUser() {
        return mUser;
    }

    /**
     * Sets the user.
     * @param user The user to set
     */
    public void setUser(User user) {
        mUser = user;
    }

    /**
     * Returns the newsfeed.
     * @return Newsfeed
     * @castor:field set-method="setNewsfeed" required="true" type="ag.Newsfeed"
     * @castor:field-sql name="newsfeed_id" sql-dirty="check" dirty="true"
     */
    public Newsfeed getNewsfeed() {
        return mNewsfeed;
    }

    /**
     * Sets the newsfeed.
     * @param newsfeed The newsfeed to set
     */
    public void setNewsfeed(Newsfeed newsfeed) {
        mNewsfeed = newsfeed;
    }
}
