<%-- 
    Document   : index
    Created on : Dec 3, 2018, 10:29:28 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2> hello <%=request.getParameter("username")%></h2>
             <h2> hello <%=request.getParameter("pass")%></h2>
    </body>
</html>
