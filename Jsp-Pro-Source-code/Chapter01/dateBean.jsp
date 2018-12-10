<html>
    <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
    </head>
  <body>
    <jsp:useBean id="date" class="com.apress.projsp.DateFormatBean"/>
    <h2>Today's Date is <%= date.getDate()%></h2>
  </body>
</html>
