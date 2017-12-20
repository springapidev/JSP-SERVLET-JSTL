<%-- 
    Document   : index
    Created on : Dec 18, 2017, 11:20:03 PM
    Author     : Rajail Islam
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1>Hello World!</h1>
    <c:out value="Hi I am JSTL working fine"/>
    <jsp:useBean id="person" class="com.coderbd.Person" scope="session"/>
    <jsp:setProperty property="*"  name="person"/>
    <c:out value="${person.name}" default="Unknown"/>

    <c:catch var="exception">
        <fmt:parseDate var="dob" value="param.birthDate" pattern="yyyy-MM-dd"/>
    </c:catch>

    <c:if test="${exception != null }">
        <jsp:useBean id="dob" class="java.util.Date"/>
    </c:if>
    <form action="index.jsp" method="post">
        <input type="text" name="birthDate"/>
        <input type="submit" value="Submit"/>
    </form>
    <c:redirect url="https://www.google.com/"/>
</html>
