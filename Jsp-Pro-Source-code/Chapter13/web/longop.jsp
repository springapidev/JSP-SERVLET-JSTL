<%@ page language="java" %>

<html>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  <body>
    <h2>Long operation - not cached</h2>
      <p>Processing started at: <%= new java.util.Date().toString() %></p>
      <% Thread.sleep(10000); %>
      <p>Processing ended at: <%= new java.util.Date().toString() %></p>
    <p>
      The reason this JSP page took so long to load is because 
      it contains a 10 second sleep.
    </p>
    <p>
      This page does not uses a page cache 
      so every time you access this page, 
      it will take 10 seconds to run.
    </p>
  </body>
</html>
