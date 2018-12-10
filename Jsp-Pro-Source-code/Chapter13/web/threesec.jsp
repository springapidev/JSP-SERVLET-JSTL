<%@ page language="java" %>

<html>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  <body>
    <h2>Three second operation</h2> 
    <p>
      The reason this page JSP took 3 seconds to load is because 
      it contains a 3 second sleep.
    </p>
    <% Thread.sleep(3000); %>
  </body>
</html>
