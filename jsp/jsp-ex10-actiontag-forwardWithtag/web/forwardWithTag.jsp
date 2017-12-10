<%-- 
    Document   : forwardWithTag
    Created on : Dec 11, 2017, 12:20:51 AM
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

        <% out.print("Today is:" + java.util.Calendar.getInstance().getTime());%>  
        <%= request.getParameter("name")%>  
    </body>
</html>
