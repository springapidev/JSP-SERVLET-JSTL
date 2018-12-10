<%@page contentType="text/html;charset=ISO-8859-15" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>Number Formatting Example </h2>
    Formatting <B>123.4</B> becomes : 
      <fmt:formatNumber value="123.4" type="NUMBER"  
                        minFractionDigits="3" /><BR>
    <hr>
    <h2>Currency Format Example </h2>
    
    <c:set var="salary" value="125000" />
    Salary (no formatting) = <c:out value="${salary}"/><BR>

    <fmt:setLocale value="en_GB"/>
    Salary (British) = 
      <fmt:formatNumber type="CURRENCY" value="${salary}" /><BR>
      
    <fmt:setLocale value="fr_CH"/>
    Salary (Swiss) = 
      <fmt:formatNumber type="CURRENCY" value="${salary}" /><BR>
      
    <fmt:setLocale value="fr_FR"/>
    Salary (French) = 
      <fmt:formatNumber type="CURRENCY" value="${salary}" /><BR>
      
    <fmt:setLocale value="it_IT"/>
    Salary (Italian) = 
      <fmt:formatNumber type="CURRENCY" value="${salary}" />
  </body>
</html>