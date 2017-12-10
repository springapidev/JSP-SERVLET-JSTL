<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello World!</h1>
        <!--Jsp scriptlet tag-->
         <%!  int x=10; %> 
        <%=   "Welcome to JSP"+x%>   
        
        <%=   "Name: " + request.getParameter("n")%>     
        <%=   "email " + request.getParameter("email")%>  
        <%=   "age " + request.getParameter("age")%>  
        <%=   "gender " + request.getParameter("gender")%>  
        <%=   "reading " + request.getParameter("reading")%>  
        <%=   "country " + request.getParameter("country")%>  
        <!--
        JSP request implicit object

The JSP request is an implicit object of type HttpServletRequest i.e. created for each jsp request by the web container. It can be used to get request information such as parameter, header information, remote address, server name, server port, content type, character encoding etc.

It can also be used to set, get and remove attributes from the jsp request scope.

Let's see the simple example of request implicit object where we are printing the name of the user with welcome message. 
        -->

    </body>
</html>
