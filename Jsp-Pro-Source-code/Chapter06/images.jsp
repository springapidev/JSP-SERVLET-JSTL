<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>

  <body>
    <%@ taglib uri="/WEB-INF/tlds/ch06.tld" prefix="ch06" %>

    <h2>Thumbnails</h2>
    The thumbnail tag can be used in several ways<p/>
    You can pass it the path to a directory:<br>
    &lt;ch06:thumbnail path="/photos"/&gt;<br>
    <ch06:thumbnail path="/photos"/>
    <p/>
    You can pass it the path to a directory and a suffix:<br>
    &lt;ch06:thumbnail path="/photos" suffix=".png"/&gt;<br>
    <ch06:thumbnail path="/photos" suffix=".png"/>
    <p/>
    You can pass the path as a request parameter and use EL to get the path:<br>
    &lt;ch06:thumbnail path="${'${'}param.path}"/&gt;<br>
    <ch06:thumbnail path="${param.path}"/>
    <p/>
    You can pass the path as a request parameter and use a scriptlet to get the path:<br>
    &lt;ch06:thumbnail path='&lt;%= request.getParameter("path") %&gt;'/&gt;<br>
    <ch06:thumbnail path='<%= request.getParameter("path") %>'/>

  </body>

</html>