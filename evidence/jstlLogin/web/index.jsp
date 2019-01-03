<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${empty sessionScope['loginUser']}">
            <c:redirect url="login.jsp" />
        </c:if>

        <a href="login.jsp">Logout 
            <c:out value="${sessionScope['loginUser']}" />
        </a>
    </body>
</html>
<!--
create database jstllogin;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
);
 
INSERT INTO `users` (`id`,`username`,`password`) VALUES
 (1,'admin','123');
-->