<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:import url="book.xml" var="url" />
<x:parse xml="${url}" var="book" scope="session" />

<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>XML 'choose' Tag</h2>

<x:choose>

  <x:when select="$book/book/publisher='Apress'">
    Another great title from Apress!
  </x:when>
  
  <x:when select="$book/book/publisher='Bloggs Publisher'">
    A reasonable title from Bloggs Publisher!
  </x:when>
  
  <x:otherwise>
    An title from an unknown publisher
  </x:otherwise>

</x:choose>

<p/>
<b><x:out select="$book/book/title"/></b><br>
<x:out select="$book/book/author"/><br>
<a href="<x:out select="$book/book/url"/>"><x:out select="$book/book/url"/></a><br>

  </body>
</html>