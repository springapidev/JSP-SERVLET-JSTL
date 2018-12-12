<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="level" value="Beginner" scope="session"/>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
Your level is <c:out value="${level}" />
<form action="core_remove.jsp" method="GET">
<input type="submit" name="beginner" value="Stay as Beginner"/>
<input type="submit" name="expert" value="Change to Expert"/>
</form>
  </body>
</html>