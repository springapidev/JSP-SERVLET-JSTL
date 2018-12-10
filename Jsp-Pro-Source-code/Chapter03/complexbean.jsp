<jsp:useBean id="person" class="com.apress.projsp.Person" scope="request" />
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL and Complex JavaBeans</h2>
    <table border="1">
      <tr>
        <td>${person.name}</td>
        <td>${person.age}</td>
        <td>${person["address"].line1}</td>
        <td>${person["address"].town}</td>
        <td>${person.address.phoneNumbers[0].std} ${person.address.phoneNumbers[0].number}</td>
        <td>${person.address.phoneNumbers[1].std} ${person.address.phoneNumbers[1].number}</td>
      </tr>    
    </table>
  </body>
</html>