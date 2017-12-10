<%-- 
    Document   : welcome
    Created on : Dec 10, 2017, 11:47:02 PM
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

            String name = request.getParameter("uname");
            out.print("Welcome " + name);

            pageContext.setAttribute("user", name, PageContext.SESSION_SCOPE);


        %>  
        <a href = "second.jsp"> second jsp page</a>  
    </body>
</html>
