package com.apress.projsp;

import java.io.*;
import javax.servlet.*;

public final class VisAuditFilter implements Filter
{
  private FilterConfig filterConfig = null;

  public void doFilter(ServletRequest request,
                       ServletResponse response, FilterChain chain)
      throws IOException, ServletException
  {
    String clientAddr = request.getRemoteAddr();
    String clientHost = request.getRemoteHost();
    filterConfig.getServletContext().log("in VisAuditFilter");
    VisAuditResponseWrapper myWrappedResp = 
      new VisAuditResponseWrapper(response,
                                  clientAddr,
                                  clientHost);
    chain.doFilter(request, myWrappedResp);

    PrintWriter writer = myWrappedResp.getWriter();
    writer.close();
    response.setContentType(myWrappedResp.getContentType());
    ReplaceContentOutputStream rcos = (ReplaceContentOutputStream) myWrappedResp
        .getOutputStream();
    byte[] result = rcos.getResult();
    response.setContentLength(result.length);
    ServletOutputStream out = response.getOutputStream();
    out.write(result);

    filterConfig.getServletContext().log(
        "Getting out of VisAuditFilter");
  }

  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {}
}
