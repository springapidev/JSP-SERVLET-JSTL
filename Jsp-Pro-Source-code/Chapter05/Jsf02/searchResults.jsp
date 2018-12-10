<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

   <f:view>
      <head>               
         <title>Freedom Airlines Online Flight Reservation System</title>
         <link rel="stylesheet" href="projsp.css">
      </head>
      <body>
            <h3>You entered these search parameters</h3>
            <br/>Trip Type  : <h:outputText value="#{flight.tripType}"/>
            <br/>Origination: <h:outputText value="#{flight.origination}"/>
            <br/>Depart date: <h:outputText value="#{flight.departDate}"/>
            <br/>Depart time: <h:outputText value="#{flight.departTime}"/>
            <br/>Destination: <h:outputText value="#{flight.destination}"/>
            <br/>Return date: <h:outputText value="#{flight.returnDate}"/>
            <br/>Return time: <h:outputText value="#{flight.returnTime}"/>
            <p/>Matching Flights
            <p/><h:outputText value="#{flight.matchingFlights[0]}"/>
            <p/><h:outputText value="#{flight.matchingFlights['1']}"/>
      </body>      
   </f:view>
</html>