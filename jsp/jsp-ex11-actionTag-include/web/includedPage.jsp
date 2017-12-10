<%-- 
    Document   : includedPage
    Created on : Dec 11, 2017, 12:26:31 AM
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
        <h1>I am from Included Page</h1>
            <% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>  
    </body>
</html>
