<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL Logic</h2>
    <table border="1">
      <tr>
        <td><b>Concept</b></td>
        <td><b>EL Expression</b></td>
        <td><b>Result</b></td>
      </tr>    
      <tr>
        <td>And</td>
        <td>${'${'}true and false}</td>
        <td>${true and false}</td>
      </tr>
      <tr>
        <td>And</td>
        <td>${'${'}true && false}</td>
        <td>${true && false}</td>
      </tr>
      <tr>
        <td>Or</td>
        <td>${'${'}true or false}</td>
        <td>${true or false}</td>
      </tr>
      <tr>
        <td>Or</td>
        <td>${'${'}true || false}</td>
        <td>${true || false}</td>
      </tr>
      <tr>
        <td>Not</td>
        <td>${'${'}not true}</td>
        <td>${not true}</td>
      </tr>
      <tr>
        <td>Not</td>
        <td>${'${'}!false}</td>
        <td>${!false}</td>
      </tr>
    </table>
  </body>
</html>