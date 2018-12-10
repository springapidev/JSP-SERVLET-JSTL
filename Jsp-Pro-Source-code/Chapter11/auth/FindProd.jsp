<%@ page buffer="none" %>
<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="../projsp.css">
  </head>
<body>
<h1>You have a submitted as the ${param.DEPT} department!</h1>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
      out.println(message);
    }
%>
</body>
</html>
