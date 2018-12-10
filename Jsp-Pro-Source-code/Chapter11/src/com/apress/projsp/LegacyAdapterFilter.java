package com.apress.projsp;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public final class LegacyAdapterFilter implements Filter
{
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request,
                       ServletResponse response, FilterChain chain)
      throws IOException, ServletException
  {

    String clientAddr = request.getRemoteAddr();
    System.out.println("the addr is " + clientAddr);
    int idx = clientAddr.indexOf(".");
    clientAddr = clientAddr.substring(idx + 1);
    idx = clientAddr.indexOf(".");
    clientAddr = clientAddr.substring(idx + 1);
    idx = clientAddr.indexOf(".");
    clientAddr = clientAddr.substring(0, idx);
    System.out.println("the subnet is " + clientAddr);
    String dept = null;
    if (clientAddr.equals("0")) {
      dept = "Engineering";
    } else {
      dept = "Accounting";
    }
    LegacyAdapterRequestWrapper aCustomReq = 
      new LegacyAdapterRequestWrapper((HttpServletRequest) request,
                                      dept);
    filterConfig.getServletContext().log("in LegacyAdapterFilter");
    chain.doFilter(aCustomReq, response);
    filterConfig.getServletContext().log("leaving LegacyAdapterFilter");
  }

  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {}
}
