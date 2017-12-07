<%-- 
    Document   : welcome
    Created on : Dec 8, 2017, 12:12:14 AM
    Author     : Rajail Islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            out.print("Welcome " + request.getParameter("uname"));

            String driver = config.getInitParameter("dname");
            out.print("driver name is=" + driver);
        %>  
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
