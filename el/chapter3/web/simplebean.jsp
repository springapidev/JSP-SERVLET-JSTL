<jsp:useBean id="person" class="com.apress.projsp.Person" scope="request">
  <jsp:setProperty name="person" property="*"/>
</jsp:useBean>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL and Simple JavaBeans</h2>
    <table border="1">
      <tr>
        <td>${person.name}</td>
        <td>${person.age}</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <form action="simplebean.jsp" method="post">
          <td><input type="text" name="name"></td>
          <td><input type="text" name="age"></td>
          <td><input type="submit"></td>
        </form>
      <tr>
    </table>
  </body>
</html>