<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:import url="books.xml" var="url" />
<x:parse xml="${url}" var="book" scope="session" />

<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>XML 'forEach' Tag</h2>

<x:forEach select="$book/books/book" var="currentBook"> 
  <x:choose>
    <x:when select="$currentBook/publisher='Apress'">
      <font color="red">
        <h1>Another great title from Apress!</h1>
      </font>
    </x:when>
  
    <x:when select="$currentBook/publisher='Bloggs Publishers'">
      <font color="red">
        <h2>A reasonable title from Bloggs Publisher!</h2>
      </font>
    </x:when>
  
    <x:otherwise>
      <font color="red">
        <h3>A title from an unknown publisher</h3>
      </font>
    </x:otherwise>
  </x:choose>

  <table border="0">
    <tr>
      <td colspan="2"><B><x:out select="$currentBook/title"/><b></td>
    </tr>
    <tr>
      <td><i>Author :</i></td>
      <td><x:out select="$currentBook/author"/></td>
    </tr>
    <tr>
      <td><i>ISBN :</i></td>      
      <td><x:out select="$currentBook/isbn"/></td>
    </tr>
    <tr>
      <td><i>Published :</i></td> 
      <td><x:out select="$currentBook/published"/></td>
    </tr>
    <tr>
      <td><i>URL :</i></td>       
      <td><a href='<x:out select="$currentBook/url"/>'><x:out select="$currentBook/title"/></a></td>
    </tr>
  </table>
  <hr>

</x:forEach>

  </body>
</html>