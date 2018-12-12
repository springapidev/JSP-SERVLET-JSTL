<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>Examples of Date & Time Formatting</h2>
    <hr>
    <h2>Default Time Zone</H2>
    Default format : <fmt:formatDate value="${now}"/><br>
    
    A Date only in a Custom dd/MM/yyyy format :
    <fmt:formatDate value="${now}" type="DATE" pattern="dd/MM/yyyy"/><br>
    
    A Time only in MEDIUM format :
    <fmt:formatDate value="${now}" type="TIME" dateStyle="MEDIUM"/><br>
    
    A Date and Time in FULL format :
    <fmt:formatDate value="${now}" type="BOTH" dateStyle="FULL"
                    timeStyle="FULL"/><br>
    <hr>
    
    <h2>America/Los_Angeles Time Zone</h2>
    <fmt:timeZone value="America/Los_Angeles">
      Default format : <fmt:formatDate value="${now}"/><br>

      A Date only in a Custom MM-dd-yyyy format :
      <fmt:formatDate value="${now}" type="DATE" pattern="MM-dd-yyyy"/><br>

      A Time only in MEDIUM format :
      <fmt:formatDate value="${now}" type="TIME" dateStyle="MEDIUM"/><br>

      A Date and Time in FULL format :
      <fmt:formatDate value="${now}" type="BOTH" dateStyle="FULL"
                      timeStyle="FULL"/><br>
    </fmt:timeZone>
  </body>
</html>  