<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  

<html>  
    <head>  
        <title>sql:query Tag</title>  
    </head>  
    <body>  

        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                           url="jdbc:mysql://localhost/student"  
                           user="root"  password="1234"/>  
        <%
            int myID = 1;

        %>
        <sql:update dataSource="${db}" var="rs">  
            update student set name='Dhaka' where id=?;  
            <sql:param value="${myID}" />  
        </sql:update>>  


    </body>  
</html>  