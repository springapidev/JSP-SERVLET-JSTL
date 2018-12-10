<%@page isELIgnored="true" %>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>Disabling EL</h2>
    <table border="1">
      <tr>
        <td>EL is no longer evaluated</td>
        <td>${1+1} is not escaped</td>
      </tr>    
    </table>
  </body>
</html>