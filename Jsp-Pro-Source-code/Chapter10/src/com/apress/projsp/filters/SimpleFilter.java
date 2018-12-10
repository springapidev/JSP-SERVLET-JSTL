package com.apress.projsp.filters;

import java.io.*;
import javax.servlet.*;

public final class SimpleFilter implements Filter {
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    filterConfig.getServletContext().log("in SimpleFilter");
    chain.doFilter(request, response);
    filterConfig.getServletContext().log("Getting out of SimpleFilter");
  }

  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
  }
}