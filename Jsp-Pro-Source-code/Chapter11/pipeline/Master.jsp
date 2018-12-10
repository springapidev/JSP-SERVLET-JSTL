<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
    <h1>First Inclusion</h1>
    <jsp:include page="Sub.jsp" flush="true">
      <jsp:param name="DEPT" value="Accounting"/>
    </jsp:include>
    <hr/>
    <h1>Second Inclusion</h1>
    <jsp:include page="Sub.jsp" flush="true">
      <jsp:param name="DEPT" value="Engineering"/>
    </jsp:include>
  </body>
</html>
