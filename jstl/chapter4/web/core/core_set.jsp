<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="browser" value="${header['User-Agent']}" scope="session" />
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
Your Browser User Agent is : <c:out value="${browser}"/>
  </body>
</html>