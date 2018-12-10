<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="en_GB" scope="request"/>
<fmt:setBundle basename="labels"/>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h2>Survey</h2>
    <form action="">
      <table>
        <tr>
          <td><fmt:message key="nameQuestion"/></td>
          <td><input type="text" size="16"></td>
        </tr>
        <tr>
          <td><fmt:message key="ageQuestion"/></td>
          <td><input type="text" size="16"></td>
        </tr>
        <tr>
          <td><fmt:message key="locationQuestion"/></td>
          <td><input type="text" size="16"></td>
        </tr>
        <tr>
          <td><input type="submit" value='<fmt:message key="submit"/>'></td>
        </tr>
      </table>
    </form>
  </body>
</html>