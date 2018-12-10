<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
  </head>
<body>
<h1>Welcome to Pro JSP Authorization Demo Application!</h1>
<p>This page tests the JAAS realm with FORM authentication.
This page is index.jsp and it is unprotected. </p>

<p>Prior to running this example, you must do the following:</p>
<ol>
<li>Run the ant build task build-jaas</li>
<li>Copy the projsp-jaas.jar file to your server's lib directory.
If you are using Tomcat, you can use the ant build task deploy-jaas
to copy the jar file (ensure the servlet.libdir property in the
tomcat.properties file points to the Tomcat common\lib directory)</li>
<li>Copy the \etc\projsp.login file to JAVA_HOME/jre/lib/security.</li>
<li>Modify the domain attribute in projsp.login to match the 
    domain or workgroup of your system</li>
<li>Add a login.config.url property to the 
    java.security file (located in $JAVA_HOME/jre/lib/security). 
    The line will look something like this: 
<pre>
login.config.url.1=file:${java.home}/lib/security/projsp.login
</pre>
    Ensure that the path to projsp.login matches the location of 
    the projsp.login file from the previous step</li>
<li>Restart Tomcat</li>
</ol>

The page <a href="jaas/jaas.html">jaas.html</a> is protected with the 
username/password jaas/jaas.
</body>
</html>
