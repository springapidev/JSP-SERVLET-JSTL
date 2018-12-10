<%@ page import="com.apress.projsp.domain.Countries" %>

<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>
	<h2>Declaring scripting variables using <code>TagExtraInfo</code></h2>
    <%@ taglib uri="/WEB-INF/tlds/ch08.tld" prefix="ch08" %>

    <%
      pageContext.setAttribute("countries", Countries.getInstance().getCountries());
    %>

    Countries :
    <ul>
    <ch08:iterate id="country" type="com.apress.projsp.domain.Country" items="${countries}">
      <li><%= country.getName() %>
    </ch08:iterate>
    </ul>

  </body>

</html>