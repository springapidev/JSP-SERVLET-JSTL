<%@ taglib prefix="projsp" uri="/WEB-INF/taglib.tld"%>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
  <h2>Nested Functions</h2>
  ${'${'}projsp:upper(projsp:source(param.name, pageContext))}<p/>
<pre>
${projsp:upper(projsp:source(param.name, pageContext))}
</pre>
  </body>
</html>