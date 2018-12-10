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
    <ch07:select name="country" label="name" value="id" items="${countries}"/>

    <%-- this is an alternative way of specifying the request-time attribute
      <ch07:select name="country" label="name" value="id" items="<%= (java.util.Collection)pageContext.findAttribute("countries") %>"/>
    --%>

  </body>
</html>