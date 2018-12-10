<%@ taglib prefix="projsp" uri="http://www.apress.com/projsp/fn"%>
<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>${param.name}</h2>
    <pre>
${projsp:source(param.name, pageContext)}
    </pre>
  </body>
</html>