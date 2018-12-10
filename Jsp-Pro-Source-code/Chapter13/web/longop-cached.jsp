<%@ page language="java" %>
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="os" %>

<html>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  <body>
    <h2>Long operation - cached</h2>
    <os:cache time="60">
      <p>Processing started at: <%= new java.util.Date().toString() %></p>
      <% Thread.sleep(10000); %>
      <p>Processing ended at: <%= new java.util.Date().toString() %></p>
    </os:cache>
    <p>
      The reason this JSP page takes so long to load when first accessed
      is because it contains a 10 second sleep.
    </p>
    <p>
			This page uses page cache with a 60 second timeout,
			so if you run this page again in the next 60 seconds
			it will take less than a second to run. In addition, because
			it is cached, the processing start and end times will
			not change until the cache expires
    </p>
  </body>
</html>
