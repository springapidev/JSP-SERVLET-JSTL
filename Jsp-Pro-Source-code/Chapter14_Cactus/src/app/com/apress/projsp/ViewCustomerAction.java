package com.apress.projsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ViewCustomerAction implements Action
{
  public String execute(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException
  {
    String id = request.getParameter("id");
    Customer customer = CustomerFactory.getInstance().getCustomer(id);
    request.setAttribute("customer", customer);
    return "/view-customer.jsp";
  }
}