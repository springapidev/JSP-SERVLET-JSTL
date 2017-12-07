<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       
        <%=   "Welcome to JSP" %>   
        
        <%=   "Name: " + request.getParameter("n")%>     
        <%=   "email " + request.getParameter("email")%>  
        <%=   "age " + request.getParameter("age")%>  
        <%=   "gender " + request.getParameter("gender")%>  
        <%=   "reading " + request.getParameter("reading")%>  
        <%=   "country " + request.getParameter("country")%>  

    </body>
</html>
