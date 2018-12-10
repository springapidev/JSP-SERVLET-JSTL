<%@ page isErrorPage="true" %>

<%@ taglib uri="http://www.tagunit.org/tagunit/display" prefix="tagunit" %>

<html>

  <head>
    <title>TagUnit - Error</title>
    <tagunit:base/>
    <link rel="stylesheet" href="page.css">
  </head>

  <body>
    <h2>Oops, there has been a problem...</h2>
    <pre><%= org.tagunit.util.ExceptionUtils.getStackTraceAsString(exception) %></pre>

  </body>

</html>