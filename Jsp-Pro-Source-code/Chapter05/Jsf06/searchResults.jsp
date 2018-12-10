<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

   <f:view>
      <head>               
         <title>Freedom Airlines Online Flight Reservation System</title>
         <link rel="stylesheet" href="projsp.css">
      </head>
      <body>
        <h3>Select a Flight</h3>
        <h:form>
        <p/><h:outputText value="#{flight.matchingFlights[0]}"/>
        <h:commandLink action="#{flight.select}" value="Select this flight">
          <f:param name="flightNum" 
             value="#{flight.matchingFlights[0].flightNum}" />
        </h:commandLink>
        <p/><h:outputText value="#{flight.matchingFlights[1]}"/>
        <h:commandLink action="#{flight.select}" value="Select this flight">
          <f:param name="flightNum" 
             value="#{flight.matchingFlights[1].flightNum}" />
        </h:commandLink>
        <p/>
        <h:commandButton value="New Search" action="#{flight.reset}"/>
        </h:form>
      </body>      
   </f:view>
</html>