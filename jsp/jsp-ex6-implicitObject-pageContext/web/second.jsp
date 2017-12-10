<%-- 
    Document   : second
    Created on : Dec 10, 2017, 11:47:22 PM
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

            String name = (String) pageContext.getAttribute("user", PageContext.SESSION_SCOPE);
            out.print("Hello " + name);

        %>  
    </body>
</html>
