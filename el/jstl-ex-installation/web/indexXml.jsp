<%-- 
    Document   : index
    Created on : Dec 20, 2017, 11:59:02 PM
    Author     : Rajail Islam
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<c:import var="bookInfo" url="https://www.w3schools.com/xml/note.xml"/>
<x:parse  xml="${bookInfo}" var="book" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <b>Data Info:</b>: 
        To: <x:out select = "$book/note[1]/to" /><br/>
       From:  <x:out select = "$book/note[1]/from" /><br/>
        Content: <x:out select = "$book/note[1]/content" /><br/>
       Body:  <x:out select = "$book/note[1]/body" /><br/>

    </body>
</html>
