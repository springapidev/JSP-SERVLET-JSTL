<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>Welcome to Pro JSP Authorization Demo Application!</h2>
    This page tests the Tomcat memory realm with FORM authentication.
    This page is index.jsp and it is unprotected. The page
    <a href="mem/memory.jsp">memory.jsp</a> is protected such that only
    users with the 'tomcat' role are allowed to access the page. If you
    have a default Tomcat install, then the username/password combos
    tomcat/tomcat or both/tomcat will be authorized for the page; but
    role1/tomcat or admin/{admin_password} will not work.
  </body>
</html>
