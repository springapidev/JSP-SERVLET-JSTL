<%@ page import="com.apress.projsp.domain.Countries" %>

<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>

    <%@ taglib uri="/WEB-INF/tlds/ch07.tld" prefix="ch07" %>

    <%
      pageContext.setAttribute("countries", Countries.getInstance().getCountries());
    %>

    Countries :
    <ul>
    <ch07:iterate var="country" items="${countries}">
      <li>${country.name}
    </ch07:iterate>
    </ul>

  </body>

</html>