package com.apress.projsp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CookieTag extends TagSupport {
  private String name;

  public void setName(String s) {
    this.name = s;
  }

  public int doStartTag() throws JspException {
    // find the current cookies
    HttpServletRequest request;
    request = (HttpServletRequest) pageContext.getRequest();
    Cookie cookies[] = request.getCookies();
    // now try to find the named cookie
    Cookie cookie = getCookie(cookies, name);
    if (cookie != null) {
      // the cookie was found so evaluate the body content
      pageContext.setAttribute(id, cookie);
      return EVAL_BODY_INCLUDE;
    } else {
      // the cookie wasn't found so skip the body content
      return SKIP_BODY;
    }
  }

  private Cookie getCookie(Cookie cookies[], String name) {
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(name)) {
          return cookies[i];
        }
      }
    }
    //   we got this far so the specified cookie wasn't found
    return null;
  }
}