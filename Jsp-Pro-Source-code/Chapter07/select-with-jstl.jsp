<%@ page import="com.apress.projsp.domain.Countries" %>

<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>

    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

    <%
      pageContext.setAttribute("countries", Countries.getInstance().getCountries());
    %>

    Countries : 
    <select name="country">
    <c:forEach var="country" items="${countries}">
      <option value="${country.id}">${country.name}</option>
    </c:forEach>
    </select>

  </body>

</html>