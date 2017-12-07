<%-- 
    Document   : methods
    Created on : Dec 7, 2017, 9:45:40 PM
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
        <%!
            public int calculateAge(int age) {
                return age;
            }
        %>

        <%=   calculateAge(Integer.parseInt(request.getParameter("age")))%> 

    </body>
</html>
