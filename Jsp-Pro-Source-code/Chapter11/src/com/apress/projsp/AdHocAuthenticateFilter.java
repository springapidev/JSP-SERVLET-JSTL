package com.apress.projsp;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import sun.misc.BASE64Decoder;

public final class AdHocAuthenticateFilter implements Filter {
  private FilterConfig filterConfig = null;
  private String adhocPassword = null;
  private String adhocGoldPassword = null;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest myReq = (HttpServletRequest) request;
    HttpServletResponse myResp = (HttpServletResponse) response;
    String authString = myReq.getHeader("Authorization");
    if (authString == null) {
      myResp.addHeader("WWW-Authenticate", "BASIC realm=\"PJSP2\"");
      myResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    } else { // authenticate
      BASE64Decoder decoder = new BASE64Decoder();
      String enString = authString.substring(6);
      String decString = new String(decoder.decodeBuffer(enString));
      int idx = decString.indexOf(":");
      String uid = decString.substring(0, idx);
      String pwd = decString.substring(idx + 1);
      if (externalGoldAuthenticate(uid, pwd)) {
        request.setAttribute("goldmember", new Boolean(true));
      } else {
        if (!externalAuthenticate(uid, pwd)) {
          myResp.addHeader("WWW-Authenticate", "BASIC realm=\"PJSP2\"");
          myResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          return;
        }
      }
    }
    filterConfig.getServletContext().log("in AdHocAuthenticateFilter");
    chain.doFilter(request, response);
    filterConfig.getServletContext().log(
        "Getting out of  " + "AdHocAuthenticateFilter");
  }

  private boolean externalAuthenticate(String user, String password) {
    if (adhocPassword == null)
      return false;
    
    return adhocPassword.equals(password);
  }

  private boolean externalGoldAuthenticate(String user, String password) {
    if (adhocGoldPassword == null)
      return false;
    
    return adhocGoldPassword.equals(password);
  }

  public void destroy() {}

  public void init(FilterConfig filterConfig) {
    if (adhocPassword == null)
      adhocPassword = filterConfig.getInitParameter("adhocpassword");
    if (adhocGoldPassword == null)
      adhocGoldPassword = filterConfig.getInitParameter("goldpassword");
    this.filterConfig = filterConfig;
  }
}
