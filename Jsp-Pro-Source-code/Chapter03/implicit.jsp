<jsp:useBean id="sessionperson" class="com.apress.projsp.Person" scope="session" />
<jsp:useBean id="requestperson" class="com.apress.projsp.Person" scope="request" >
  <jsp:setProperty name="requestperson" property="*"/>
</jsp:useBean>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>Implicit Variables Examples</h2>
    <table border="1">
      <tr>
        <th><b>Concept</b></th>
        <th><b>Code</b></th>
        <th><b>Output</b></th>
      </tr>
      <tr>
        <td>PageContext</td>
        <td>${'${'}pageContext.request.requestURI}</td>
        <td>${pageContext.request.requestURI}</td>
      </tr>
      <tr>
        <td>sessionScope</td>
        <td>${'${'}sessionScope.sessionperson.name}</td>
        <td>${sessionScope.sessionperson.name}</td>
      </tr>
      <tr>
        <td>requestScope</td>
        <td>${'${'}requestScope.requestperson.name}</td>
        <td>${requestScope.requestperson.name}</td>
      </tr>
      <tr>
        <td>param</td>
        <td>${'${'}param["name"]}</td>
        <td>${param["name"]}</td>
      </tr>
      <tr>
        <td>paramValues</td>
        <td>${'${'}paramValues.multi[1]}</td>
        <td>${paramValues.multi[1]}</td>
      </tr>
    </table>
  </body>
</html>