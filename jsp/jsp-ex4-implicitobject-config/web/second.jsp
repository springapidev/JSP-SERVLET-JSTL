<%-- 
    Document   : newjspsecond
    Created on : Dec 8, 2017, 12:41:07 AM
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

            String name = (String) session.getAttribute("n");
            out.print("Hello " + name);

        %> 
    </body>
</html>
