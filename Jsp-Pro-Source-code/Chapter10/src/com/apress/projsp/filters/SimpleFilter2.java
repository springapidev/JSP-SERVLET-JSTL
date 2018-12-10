package com.apress.projsp.filters;

import java.io.IOException;
import javax.servlet.*;

public final class SimpleFilter2 implements Filter {
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    filterConfig.getServletContext().log("in SimpleFilter2");
    chain.doFilter(request, response);
    filterConfig.getServletContext().log("leaving SimpleFilter2");
  }

  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
  }
}