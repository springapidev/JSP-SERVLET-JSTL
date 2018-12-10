<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:import url="book.xml" var="url" />
<x:parse xml="${url}" var="book" scope="session" />

<x:set select="$book/book/title" var="title" scope="session"/>
<x:set select="$book/book/author" var="author" scope="session"/>
<x:set select="$book/book/url" var="bookUrl" scope="session"/>

<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>XML 'set' Tag</h2>

<b>
  <x:out select="$title" />
</b><br>
<x:out select="$author" /><br>
<a href="<x:out select="$bookUrl" />"><x:out select="$bookUrl" /></a><br>

  </body>
</html>