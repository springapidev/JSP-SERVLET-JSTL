package com.apress.projsp;

import java.io.*;
import javax.servlet.*;

public final class SimpleFilter implements Filter {
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    filterConfig.getServletContext().log("in SimpleFilter");
    Object curVal = request.getAttribute("MsgOut");
    if (curVal == null) {
      request.setAttribute("MsgOut", new String("SimpleFilter"));
    } else {
      request.setAttribute("MsgOut", (String) curVal + " : SimpleFilter");
    }
    chain.doFilter(request, response);
    filterConfig.getServletContext().log("leaving SimpleFilter");
  }

  public void init(FilterConfig arg0) throws ServletException {
    this.filterConfig = arg0;
  }

  public void destroy() {
  }
}
