<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.expert != null}">
  <c:remove var="level" scope="session"/>
</c:if>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    Your level is <c:out value="${level}" default="Expert"/>
    <c:choose>
      <c:when test="${level != null}">
        <p/>Here are the things you need to do...
      </c:when>
      <c:otherwise>
        <p/>You're the expert, you figure it out...
      </c:otherwise>
    </c:choose>
  </body>
</html>