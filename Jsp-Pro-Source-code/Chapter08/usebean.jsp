<%@ page import="com.apress.projsp.domain.Forums" %>

<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>

    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

    <jsp:useBean id="forum" class="com.apress.projsp.domain.Forum" scope="page">
      <jsp:setProperty name="forum" property="id" value="1"/>
      <jsp:setProperty name="forum" property="name" value="Servlets"/>
    </jsp:useBean>

    <%
      pageContext.setAttribute("forums", Forums.getInstance().getForums());
    %>

    <c:forEach var="forum" items="${forums}">
      <c:out value="${forum.name}"/>
    </c:forEach>

  </body>

</html>