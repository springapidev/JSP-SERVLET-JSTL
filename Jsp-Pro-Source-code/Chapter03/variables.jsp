<jsp:useBean id="requestPerson" class="com.apress.projsp.Person" scope="request">
  <jsp:setProperty name="requestPerson" property="*"/>
</jsp:useBean>
<jsp:useBean id="sessionPerson" class="com.apress.projsp.Person" scope="session" />
<jsp:useBean id="applicationPerson" class="com.apress.projsp.Person" scope="application" >
  <jsp:setProperty name="applicationPerson" property="name" value="Kirk Linsky" />
</jsp:useBean>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL Named Variables</h2>
    
    This page creates three JavaBean objects, one each in request, session, and
    application scope. The request object is initialized from the request parameters.
    The session object uses the default constructor values. The application object
    is initialized by a hardcoded string in the page. <p/>
    
    If you enter a name and click the submit button, a new request object is created
    from the request parameter, but the session and application object are not
    changed.<p/>
    
    <table border="1">
      <tr>
        <td><b>Request</b></td>
        <td><b>Session</b></td>
        <td><b>Application</b></td>
      </tr>    
      <tr>
        <td>Hello ${requestPerson.name}</td>
        <td>Hello ${sessionPerson.name}</td>
        <td>Hello ${applicationPerson.name}</td>
      </tr>
      <tr>
        <form action="variables.jsp" method="get">
          <td><input type="text" value="${request.name}" name="name"></td>
          <td colspan=2><input type="submit"></td>
        </form>
      </tr>
    </table>
  </body>
</html>