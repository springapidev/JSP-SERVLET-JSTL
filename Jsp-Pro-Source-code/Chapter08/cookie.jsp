<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>
	<h2>Declaring scripting variables using the TLD file</h2>
    <%@ taglib uri="/WEB-INF/tlds/ch08.tld" prefix="ch08" %>

    <%
      java.util.Date d = new java.util.Date();
      Cookie cookie = new Cookie("lastVisited", d.toString());
      HttpServletResponse httpResponse = (HttpServletResponse)pageContext.getResponse();
      httpResponse.addCookie(cookie);
    %>

    <ch08:cookie id="myCookie" name="lastVisited">
      You last visited this website on <%= myCookie.getValue() %>
    </ch08:cookie>
    
    </p>If no cookie for last-visited is displayed, refresh this page

  </body>

</html>