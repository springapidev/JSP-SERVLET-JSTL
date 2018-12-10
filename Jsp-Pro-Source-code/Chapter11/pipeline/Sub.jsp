<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h1>You have accessed this page from the ${param.DEPT} department!</h1>
    ${param.MsgForwarder}<br/>
    ${requestScope.MsgOut}
  </body>
</html>
