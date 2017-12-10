<%-- 
    Document   : newjspwelcome
    Created on : Dec 8, 2017, 12:25:16 AM
    Author     : Rajail Islam
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
        <%
            out.print("Welcome " + request.getParameter("uname"));
            session.setAttribute("n", request.getParameter("uname"));
          
        %>  
        <a href="second.jsp">second jsp page</a>  
    </body>
</html>
