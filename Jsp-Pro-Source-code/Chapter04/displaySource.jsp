<html>

  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>

<%@ taglib uri="/bodyTaglib" prefix="body" %>

<% String file = request.getParameter("file"); %>

<body>

<p>
<h3>Source for <%= file %></h3>
</p>

<body:encodeHTML preTag="true">
  <body:includeFile file="<%= file %>" />
</body:encodeHTML>


</body>

</html>