<html>
  <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
  <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

  <f:view>
    <head>               
      <title>Freedom Airlines Online Flight Reservation System</title>
      <link rel="stylesheet" href="projsp.css">
    </head>
    <body>
      <h3>Search Results</h3>
      <h:form>
      <p/>No flights that match your search parameters were found.
      <p/><h:commandButton value="New Search" action="#{flight.reset}"/>
      </h:form>
    </body>      
  </f:view>
</html>