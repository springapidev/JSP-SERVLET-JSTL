<html>
    <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
    </head>
  <body>
    <jsp:useBean id="date" class="com.apress.projsp.DateFormatBean">
      <jsp:setProperty name="date" property="format" 
           value="EEE, d MMM yyyy HH:mm:ss z"/>
    </jsp:useBean>
    <h2>Today's Date is <jsp:getProperty name="date" property="date"/></h2>
  </body>
</html>
