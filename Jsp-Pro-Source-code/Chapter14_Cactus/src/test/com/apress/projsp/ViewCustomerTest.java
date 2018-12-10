package com.apress.projsp;

import javax.servlet.ServletException;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;

public class ViewCustomerTest extends ServletTestCase
{
  public ViewCustomerTest(String theName) {
    super(theName);
  }

  public static Test suite() {
    return new TestSuite(ViewCustomerTest.class);
  }

  public void beginExecute(WebRequest webRequest) {
    webRequest.addParameter("id", "123");
  }

  public void testExecute() {
    Customer customer = CustomerFactory.getInstance()
        .getCustomer("123");
    ViewCustomerAction action = new ViewCustomerAction();
    try {
      action.execute(this.request, this.response);
      assertEquals(customer, request.getAttribute("customer"));
    } catch (ServletException e) {
      fail();
    }
  }
}