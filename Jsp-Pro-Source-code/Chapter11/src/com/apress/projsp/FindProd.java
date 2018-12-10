package com.apress.projsp;

import javax.servlet.http.*;
import java.io.*;

public class FindProd extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws java.io.IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<html><head>");
    out.println("<title>Professional JSP 2, 4th Edition</title>");
    out.println("<link rel=\"stylesheet\" href=\"../projsp.css\">");
    out.println("</head>");
    out.println("<body><h1>You have called from the "
        + req.getParameter("DEPT"));
    out.println(" department!</h1>");
    String message = (String) req.getAttribute("message");
    if (message != null) {
      out.println(message);
    }
    out.println("</body></html>");
    out.close();
  }
}