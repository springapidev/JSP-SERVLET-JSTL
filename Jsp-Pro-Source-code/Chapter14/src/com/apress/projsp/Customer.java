/*
 * Created on Dec 5, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.apress.projsp;

public class Customer
{
  private String firstName;
  private String lastName;
  
  public void setFirstName(String name) {
    firstName = name;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String name) {
    lastName = name;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getFullName() {
    return getFirstName() + " " + getLastName();
  }
}
