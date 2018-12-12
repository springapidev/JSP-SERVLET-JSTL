<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="book" class="com.apress.projsp.Book">
  <jsp:setProperty name="book" property="title" value="Pro JSP 2, 4th Edition"/>
  <jsp:setProperty name="book" property="author" value="Brown et al."/>
  <jsp:setProperty name="book" property="isbn" value="1-59059-513-0"/>
  <jsp:setProperty name="book" property="url" value="http://www.apress.com/book/bookDisplay.html?bID=464"/>
</jsp:useBean>

<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
The latest offering from Apress is <i><c:out value="${book.title}"/></i><BR>
Author: <c:out value="${book.author}"/><BR>
ISBN  : <c:out value="${book.isbn}"/><BR>
URL   : <a href="<c:out value="${book.url}"/>"><c:out value="${book.title}"/></a>
  </body>
</html>