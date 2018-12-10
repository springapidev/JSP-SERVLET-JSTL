<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  <body>
    <%! static String lock = new String(); %>
    <h2>Three second operation: single-threaded</h2>
    <p>
      The reason this page JSP took 3 seconds to load is because 
      it contains a 3 second sleep.
    </p>
<% synchronized (lock)
  {
    Thread.sleep(3000);
  }
%>

  </body>
</html>
