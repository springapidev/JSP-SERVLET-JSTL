<%-- 
    Document   : index
    Created on : Dec 21, 2017, 12:16:53 AM
    Author     : Rajail Islam
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href = "<c:url value = "/indexXml.jsp"/>">Xml Read</a>
    </body>
</html>
