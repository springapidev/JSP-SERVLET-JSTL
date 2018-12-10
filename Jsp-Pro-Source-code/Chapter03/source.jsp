<%@ taglib prefix="projsp" uri="/WEB-INF/taglib.tld"%>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <pre>
${projsp:source(param.name, pageContext)}
    </pre>
  </body>
</html>