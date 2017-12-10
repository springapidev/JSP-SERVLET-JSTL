<%-- 
    Document   : index
    Created on : Dec 10, 2017, 1:36:41 PM
    Author     : J2EE-33
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div>Our First Form | JSP Example</div>
        <form action="action.jsp" method="POST">
            <input type="text" name="fname"/>
            <input type="submit" value="Send"/>
            
        </form>
    </body>
</html>
