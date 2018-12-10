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
    <ch07:selectWithDynamicAttributes name="country" label="name" value="id" items="${countries}" size="3"/>

  </body>

</html>