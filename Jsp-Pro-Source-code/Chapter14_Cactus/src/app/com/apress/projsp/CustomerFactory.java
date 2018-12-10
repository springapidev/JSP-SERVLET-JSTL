package com.apress.projsp;

public class CustomerFactory {

  static CustomerFactory _ref = new CustomerFactory();
  
  public static CustomerFactory getInstance() {
    return _ref;
  }
  
  public Customer getCustomer(String id) {
    return new Customer(id);
  }
}