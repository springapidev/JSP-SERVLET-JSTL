<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
<body>
<h2>Welcome to Pro JSP Authorization Demo Application!</h2>
<p>This page tests the Tomcat JDBC realm with BASIC authentication.
This page is index.jsp and it is unprotected. </p>

<p>Prior to running this example, you must do the following:</p>
<ol>
<li>Create a database table for users and roles. 
See <a href="security.jsp">security.sql</a>
for a MySQL script</li>
<li>Copy the JDBC driver JAR file to the Tomcat common/lib or server/lib
directory (Note: copying the JAR file to the application WEB-INF/lib 
directory will NOT work)</li>
<li>Edit context.xml as needed to match the database you created.</li>
</ol>

The page <a href="jdbc/jdbc.jsp">jdbc.jsp</a> is protected with the 
username/password tomcat/mysql.<p/>

If you want to try this example with HSQLDB, follow these steps:
<ol>
  <li>Download an HSQL distribution (We used 1.8 when we tested)</li>
  <li>Copy the hsqldb.jar file to the Tomcat common/lib or server/lib
  directory (Note: copying the JAR file to the application WEB-INF/lib 
  directory will NOT work)</li>
  <li>Change the database.engine property in the ant.properties
  file to be 'hsqldb'</li>
  <li>Run the ant target start-hsql. The data and script to 
  initialize the security tables are in the distribution data
  directory.</li>
  <li>Open a browser and access this page. The page 
  <a href="jdbc/jdbc.jsp">jdbc.jsp</a> is now protected with the 
  username/password tomcat/hsqldb.</li>
</ol>
</body>
</html>
