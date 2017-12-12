<%-- 
    Document   : index
    Created on : Dec 13, 2017, 1:25:45 AM
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
        <form action="SaveServlet" method="post">
            <input type="submit" value="Save Page"/>
                 </form>
         <form action="EditServlet" method="post">
                <input type="submit" value="Edit Page"/>
        </form>
        
    </body>
</html>
