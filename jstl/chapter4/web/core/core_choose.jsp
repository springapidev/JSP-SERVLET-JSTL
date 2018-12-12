<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.apress.projsp.CalendarBean"%>
<jsp:useBean id="cal" class="com.apress.projsp.CalendarBean"/>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    The time is currently : <BR><BR>
    <c:out value="${cal.time}"/>,

    <c:set var="hour" value="${cal.hour}" scope="request" />

    <b>
    <c:choose>
      <c:when test="${hour >= 0 && hour <=11}">
        Good Morning!
      </c:when>
      <c:when test="${hour >= 12 && hour <=17}">
        Good Afternoon!
      </c:when>
      <c:otherwise>
        Good Evening!
      </c:otherwise>
    </c:choose>
    </b>
  </body>
</html>
