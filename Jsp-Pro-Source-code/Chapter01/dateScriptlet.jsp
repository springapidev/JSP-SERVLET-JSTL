<%@ page import="java.util.Date, java.text.DateFormat"%>
<html>
    <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
    </head>
  <body>
    <% 
       DateFormat df = DateFormat.getInstance(); 
       Date today = new Date();    
    %>

    <h2>Today's Date is <%= df.format(today) %></h2>
  </body>
</html>
