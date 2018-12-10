<%@ taglib prefix="projsp" uri="/WEB-INF/taglib.tld"%>
<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
  <h2>Using functions to preprocess params</h2>
  Creating a bean and setting its string property to 
  ${'${'}projsp:upper('a string')}...<p/>
    <jsp:useBean id="sb" class="com.apress.projsp.SourceBean"/>
    <jsp:setProperty name="sb" property="string"
                     value="${projsp:upper('a string')}" />
  Printing value of string property: ${'${'}sb.string} = ${sb.string}
</body>
</html>