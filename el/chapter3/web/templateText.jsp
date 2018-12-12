<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL and Template Text</h2>
    <table border="1">
      <tr>
        <td colspan="2">Hello ${param['name']}</td>
      </tr>
      <tr>
        <form action="templateText.jsp" method="post">
          <td><input type="text" name="name"></td>
          <td><input type="submit"></td>
        </form>
      </tr>
    </table>
  </body>
</html>
