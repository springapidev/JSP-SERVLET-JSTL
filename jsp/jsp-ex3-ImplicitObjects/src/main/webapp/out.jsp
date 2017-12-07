<%-- 
    Document   : out
    Created on : Dec 7, 2017, 11:38:56 PM
    Author     : Rajail Islam
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>  
        <!-- Or --->
        <%!
            PrintWriter out=response.getWriter();
            %>
    </body>
</html>
