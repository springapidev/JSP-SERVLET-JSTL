package com.apress.projsp;

import java.util.HashSet;
import java.util.Set;


/**
 * @author dmj
 * @castor:class name="User" table="user" id="id"
 *  key-generator="UUID" auto-complete="true"
 */
public class User {
    private String mId = "";
    private String mName = "";
    private Set mSubscriptions = new HashSet();

    public User() {
    }

    public User(String name) {
        mName = name;
    }

    /**
     * Returns the ID.
     * @return String
     * @castor:field set-method="setId" required="true"
     * @castor:field-sql name="id" sql-dirty="check" dirty="true"
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the ID.
     * @param D The iD to set
     */
    public void setId(String iD) {
        mId = iD;
    }

    /**
     * Returns the subscriptions.
     * @return Set
     * @castor:field set-method="setSubscriptions" type="ag.Subscription"
     *      required="true" collection="set"
     * @castor:field-sql many-table="subscription"
     *      many-key="user_id" sql-dirty="check" dirty="true"
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
    
    public String toString() {
      return getName();
    }
}
