package com.apress.projsp;

import junit.framework.*;

public class CustomerTest extends TestCase
{
  public static Test suite() {
    TestSuite suite = new TestSuite(CustomerTest.class);
    return suite;
  }

  public void testFirstName() {
    Customer customer = new Customer();
    customer.setFirstName("Simon");
    assertEquals("Simon", customer.getFirstName());
  }

  public void testLastName() {
    Customer customer = new Customer();
    customer.setLastName("Brown");
    assertEquals("Brown", customer.getLastName());
  }

  public void testFullName() {
    Customer customer = new Customer();
    customer.setFirstName("Simon");
    customer.setLastName("Brown");
    assertEquals("Simon Brown", customer.getFullName());
  }
}