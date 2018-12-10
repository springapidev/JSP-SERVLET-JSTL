<html>
  <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
  <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

  <f:view>
  <head>
    <title>Freedom Airlines Online Flight Reservation System</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h3>Flight Reservation</h3>
    <h:form>
      <p/>You selected this flight: 
      <p/><h:outputText value="#{flight.matchingFlight}"/>
      <p/><h:commandButton value="New Search" action="#{flight.reset}"/>
    </h:form>
  </body>  
  </f:view>
</html>