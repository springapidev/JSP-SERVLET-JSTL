<%-- 
    Document   : action
    Created on : Dec 11, 2017, 2:09:09 AM
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
          <jsp:useBean id="person" class="com.coderbd.domain.Person" scope="session"></jsp:useBean>  
        <jsp:setProperty property="*" name="person"/>  

        Record:<br>  
        <jsp:getProperty property="name" name="person"/><br>  
        
    </body>
</html>
