<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
  <f:view>
  <f:loadBundle basename="com.apress.projsp.messages" var="msgs"/>
  <head>
    <title><h:outputText value="#{msgs.title}"/></title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h:form>
      <h2><h:outputText value="#{msgs.head}"/></h2>
      <h:outputText value="#{msgs.type}"/>
      <h:selectOneRadio layout="lineDirection"
                        value="#{flight.tripType}">
        <f:selectItems value="#{types.tripTypes}"/>
      </h:selectOneRadio>
      <p/>            
      <table>
        <tr><td colspan="4"><h:outputText value="#{msgs.searchLabel}"/></td></tr>
        <tr>
          <td colspan="2"><h:outputText value="#{msgs.departAirport}"/></td>
          <td colspan="2"><h:outputText value="#{msgs.arriveAirport}"/></td>
        </tr>
        <tr>
          <td colspan="2">
            <h:inputText id="origination" 
               value="#{flight.origination}" size="35"/>
            <h:message for="origination"/>
          </td>
          <td colspan="2">
            <h:inputText id="destination"
               value="#{flight.destination}" size="35"/>
            <h:message for="destination"/>
          </td>
        </tr>
        <tr>
          <td colspan="2"><h:outputText value="#{msgs.departLabel}"/></td>
          <td colspan="2"><h:outputText value="#{msgs.returnLabel}"/></td>
        </tr>
        <tr>
          <td>
            <h:inputText id="departDate" value="#{flight.departDate}">
              <f:convertDateTime pattern="MM/dd/yy"/>
              <f:validator validatorId="date.validator"/>
            </h:inputText>
            <h:message for="departDate"/>
          </td>
          <td>
            <h:selectOneMenu value="#{flight.departTime}">
              <f:selectItems value="#{times.times}"/>
            </h:selectOneMenu>
          </td>
          <td>
            <h:inputText id="returnDate" value="#{flight.returnDate}">
              <f:convertDateTime pattern="MM/dd/yy"/>
              <f:validator validatorId="date.validator"/>
            </h:inputText>
            <h:message for="returnDate"/>
          </td>
          <td>
            <h:selectOneMenu value="#{flight.returnTime}">
              <f:selectItems value="#{times.times}"/>
            </h:selectOneMenu>
          </td>
        </tr>
      </table>
      <p>
      <h:commandButton value="#{msgs.searchButton}" action="#{flight.search}"/>
      </p>
    </h:form>
   </body>
   </f:view>
</html>