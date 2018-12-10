package com.apress.projsp.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public final class AuditFilter implements Filter {
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    long startTime = System.currentTimeMillis();
    String remoteAddress = request.getRemoteAddr();
    String remoteHost = request.getRemoteHost();
    HttpServletRequest myReq = (HttpServletRequest) request;
    String reqURI = myReq.getRequestURI();
    chain.doFilter(request, response);
    filterConfig.getServletContext().log(
        "User at IP " + remoteAddress + "(" + remoteHost
            + ") accessed resource " + reqURI + " and used "
            + (System.currentTimeMillis() - startTime) + " ms");
  }

  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
  }
}