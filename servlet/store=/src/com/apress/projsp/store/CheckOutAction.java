package com.apress.projsp.store;

import javax.servlet.*;
import javax.servlet.http.*;

public class CheckOutAction implements Action {

  public String process(HttpServletRequest req, HttpServletResponse res)
      throws ServletException {

    return "/checkout.jsp";

  }

}