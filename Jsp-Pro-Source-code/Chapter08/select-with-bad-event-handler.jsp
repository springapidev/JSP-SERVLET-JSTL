<%@ page import="com.apress.projsp.domain.Forums" %>

<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>

    <%@ taglib uri="/WEB-INF/tlds/ch08.tld" prefix="ch08" %>

    <%
      pageContext.setAttribute("forums", Forums.getInstance().getForums());
    %>

    Forums : 
    <ch08:select name="forum" label="name" value="id" items="${forums}">
      <ch08:eventHandler name="onDoubleClick">
        window.location=('view-forum.jsp&forumId='
                         + this.options[this.selectedIndex].value)
      </ch08:eventHandler>
    </ch08:select>

  </body>

</html>