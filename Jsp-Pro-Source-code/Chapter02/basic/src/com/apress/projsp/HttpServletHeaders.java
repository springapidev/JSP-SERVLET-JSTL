package com.apress.projsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HttpServletHeaders extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");

    out.println("<title>Professional JSP 2, 4th Edition</title>");
    out.println("<link rel=\"stylesheet\" href=\"projsp.css\">");
    out.println("</head>");
    out.println("<body>");

    out.println("<h3>Headers</h3>");
    out.println("<table border=\"1\">");
    Enumeration e = request.getHeaderNames();
    while (e.hasMoreElements()) {
      String headerName = (String) e.nextElement();
      String headerValue = request.getHeader(headerName);
      out.println("<tr><td>");
      out.println(headerName);
      out.println("</td><td>");
      out.println(headerValue);
      out.println("</td></tr>");
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doGet(request, response);
  }
}