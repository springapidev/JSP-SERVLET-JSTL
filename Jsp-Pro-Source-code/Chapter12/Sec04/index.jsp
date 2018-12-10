<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
<body>
<h2>Welcome to Pro JSP Authorization Demo Application!</h2>
<p>This page tests the Tomcat JNDI realm with BASIC authentication.
This page is index.jsp and it is unprotected. </p>

<p>Prior to running this example, you must do the following:</p>
<ol>
<li>Install or gain access to an <a href="http://www.openldap.org">ldap server for *nix</a> or
<a href="http://lucas.bergmans.us/hacks/openldap/">ldap server</a>
for Windows</li>
<li>Add an include statement for cosine.schema and inetorgperson.schema to the slapd.conf file</li>
<li>Change the database settings in the slapd.conf file</li>
<li>Create the ldif entries using the <a href="ldif.jsp">ldif.entries files</a></li>
<li>Download the LDAP service provider from Sun's <a href="http://java.sun.com/products/jndi/downloads/index.html">JNDI page</a></li>
<li>Extract ldap.jar from the LDAP service provider download and
copy it to the /common/lib directory</li>
<li>Start the ldap server</li>
</ol>

The page
<a href="jndi/jndi.html">jndi.html</a> is protected with the username/password tomcat/jndi.
</body>
</html>
