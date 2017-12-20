<%-- 
    Document   : index
    Created on : Dec 21, 2017, 12:31:39 AM
    Author     : Rajail Islam
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES" scope="request"/>
<fmt:setBundle basename="labels"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Survey</h1>
        <form>
            <table>
                <tr>
                    <td><fmt:message key="nameQuestion"/></td>
                    <td><input type="text" size="16"/></td>
                </tr>
                 <tr>
                    <td><fmt:message key="ageQuestion"/></td>
                    <td><input type="text" size="16"/></td>
                </tr>
             <tr>
                   
                 <td><input type="submit" value='<fmt:message key="submit"/>'/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
