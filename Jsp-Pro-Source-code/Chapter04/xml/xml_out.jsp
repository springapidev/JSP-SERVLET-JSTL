<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<c:import url="book.xml" var="url" />
<x:parse xml="${url}" var="book" scope="session" />
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>XML 'out' Tag</h2>
<b>
  <x:out select="$book/book/title"/>
</b><br>
<x:out select="$book/book/author"/><br>
<a href="<x:out select="$book/book/url"/>"><x:out select="$book/book/url"/></a><br>


  </body>
</html>