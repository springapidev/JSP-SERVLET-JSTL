package com.apress.projsp;

public class Customer
{
  private String id;
  private String firstName;
  private String lastName;
  
  public Customer() {
    this("");
  }
  
  public Customer(String id) {
    this.id = id;
  }  
  
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
  
  public boolean equals(Object o) {
    Customer c = (Customer) o;
    return id.equals(c.id);
  }
}
