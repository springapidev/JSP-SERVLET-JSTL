<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
  </head>
<body>
<h2>Welcome to Pro JSP Authorization Demo Application!</h2>
<p>This page tests the JAAS realm with BASIC authentication.
This page is index.jsp and it is unprotected. </p>

<p>Prior to running this example, you must do the following:</p>
<ol>
<li>Download Andy Armstrong’s 
    <a href="http://free.tagish.net/jaas">JAAS login modules</a>
    </li>
<li>Extract the contents of the zip file you downloaded</li>
<li>From the contents you just unzipped copy the NTSystem.dll 
    file to the JAVA_HOME/jre/lib/security directory</li>
<li>From the contents you unzipped in step 2, copy 
    "\Sample config\tagish.login" to JAVA_HOME/jre/lib/security.
    </li>
<li>Modify the domain attribute in tagish.login to match the 
    domain or workgroup of your system</li>
<li>Copy the last few lines from 
    "\Sample config\java.security.sample" and put it at the 
    end of the java.security file (located in 
    $JAVA_HOME/jre/lib/security). 
    This line looks as follows: 
<pre>
login.config.url.1=file:${java.home}/lib/security/tagish.login
</pre>
    Ensure that the path to tagish.login matches the location of 
    the file from the previous step</li>
<li>Copy tagishauth.jar to Tomcat common\lib</li>
<li>Restart Tomcat</li>
</ol>

The page
<a href="jaas/jaas.html">jaas.html</a> is protected with the username/password of your system login.
</body>
</html>
