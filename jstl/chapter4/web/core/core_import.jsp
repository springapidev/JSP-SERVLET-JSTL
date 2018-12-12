<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" href="../projsp.css">
  </head>
  <body>
  The tag <code>&lt;pre&gt;&lt;c:import url="/xml/books.xml"/&gt;&lt;/pre&gt;</code> 
  causes the XML file named in the url attribute to be included in this 
  page. (Although the browser does not display the xml tags.)<p/>
<pre><c:import url="/xml/books.xml"/></pre>
  </body>
</html>



