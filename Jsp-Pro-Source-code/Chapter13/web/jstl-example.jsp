<%@ page language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
  <head>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body bgcolor="#ffffff">

    <sql:query var="items" 
  	  dataSource="jdbc:hsqldb:hsql://localhost,org.hsqldb.jdbcDriver,sa">
      SELECT TITLE,TIME FROM ITEM ORDER BY TIME
    </sql:query>
  
    <h1>News Items</h1>
  
    <table border="1">
      <th>Title</th><th>Time</th>
      <c:forEach var="row" items="${items.rows}">
      <tr>
        <td><c:out value="${row.TITLE}"/></td>
        <td><c:out value="${row.TIME}"/></td>
      </tr>
      </c:forEach>
    </table>
		
  </body>
</html>
