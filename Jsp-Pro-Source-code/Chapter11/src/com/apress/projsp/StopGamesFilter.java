package com.apress.projsp;

import java.io.*;
import javax.servlet.*;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.*;

public final class StopGamesFilter implements Filter
{
  private FilterConfig filterConfig = null;
  private int starthour = 0;
  private int stophour = 24; // default is to allow all the time

  public void doFilter(ServletRequest request,
                       ServletResponse response, FilterChain chain)
      throws IOException, ServletException
  {
    Calendar myCal = Calendar.getInstance();
    int curhour = myCal.get(Calendar.HOUR_OF_DAY);
    filterConfig.getServletContext().log(
                                         "in StopGamesFilter cur:"
                                             + curhour + ", start: "
                                             + starthour + ", end: "
                                             + stophour);
    if ((curhour >= stophour) || (curhour < starthour)) {
      PrintWriter out = response.getWriter();
      out.println("<html><head>");
      out.println("<title>Professional JSP 2, 4th Edition</title>");
      out.println("<link rel=\"stylesheet\" href=\"../projsp.css\">");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Sorry, game playing is not allowed at this time!</h1>");
      out.println("<p>Game playing is allowed between " +
                  starthour + ":00 and " + stophour + ":00</p>");
      out.println("</body></html>");
      out.flush();
      filterConfig.getServletContext()
          .log("Access to game page denied");
      return;
    }
    filterConfig.getServletContext().log("Access to game page granted");
    HttpServletRequestWrapper hsrw = 
      new HttpServletRequestWrapper((HttpServletRequest) request);
    hsrw.setAttribute("message",
                         "If you are seeing this page, the filter has "+
                         "authorized you to play games at this time.");
    chain.doFilter(request, response);
    filterConfig.getServletContext()
        .log("Getting out of StopGamesFilter");
  }

  public void init(FilterConfig arg0) throws ServletException {
    String tpString;
    filterConfig = arg0;
    if ((tpString = filterConfig.getInitParameter("starthour")) != null)
      starthour = Integer.parseInt(tpString, 10);
    if ((tpString = filterConfig.getInitParameter("stophour")) != null)
      stophour = Integer.parseInt(tpString, 10);
  }

  public void destroy() {}
}
