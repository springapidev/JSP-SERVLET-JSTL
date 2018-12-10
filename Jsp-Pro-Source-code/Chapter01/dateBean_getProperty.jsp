<html>
    <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
    </head>
  <body>
    <jsp:useBean id="date" 
            class="com.apress.projsp.DateFormatBean"/>
    <h2>Today's Date is <jsp:getProperty name="date"
                             property="date"/></h2>
  </body>
</html>
