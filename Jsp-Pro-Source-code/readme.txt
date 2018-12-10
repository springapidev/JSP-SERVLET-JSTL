Professional JSP 2, 4th EditionApress Pro JSP 2, 4th Edition

Welcome to the code supplement for the Apress book Professional JSP 2, 4th 
Edition. This archive contains all the source code for every example in the 
book, with the exception of the struts-resume example from Chapter 15. The 
struts-resume example is a separate download available from sourceforge.net. The 
download details for the struts-resume example are discussed later. 

Things to do before compiling or deploying

  Modify tomcat.properties for your tomcat server. If you aren't using a Tomcat 
  server, you can ignore this. 

  Modify ant.properties in Chapter 9 and Chapter 13 to set the tomcat.version 
  property to reflect the Tomcat server version. If you are not using Tomcat, 
  you must still set a server version, or you can modify the build.xml file so 
  that the build does not check for tomcat.version, and so that the build does 
  not create the META-INF/context.xml file. 

  Download and install Ant. We used version 1.6.5 

  Download and install an application server. We tested the examples on Tomcat 
  5.0.28 and Tomcat 5.5.12 

  If you are using Tomcat, download the Tomccat Deployer library and copy the 
  catalina-ant.jar file to the catalina-ant directory 

  Download and install support libraries (see below). 

General instructions

Although all the example source code is here, this archive does not include the 
supporting Java libraries needed for each example. You will need to download 
these libraries separately and add the appropriate JAR files (as listed below) 
to the directory structure created when you unzipped the source code. The 
libraries needed for each example will be listed below, and summarized again at 
the end of the list of examples.

In addition, some of the JAR files must be copied to your server's lib 
directory. For Tomcat, that will be the common/lib or server/lib directory. 
Consult your server docs for the specific directory used by your application 
server. The list of JAR files to be copied to the lib directory is given near 
the end of this page.

After downloading the required libraries and copying the necessary JAR files to 
the appropriate directories, you can use Ant to build and deploy the examples. 
Each Chapter has its own Ant build.xml file, so that you can build and deploy 
each example individually. Each chapter has the same basic set of build targets. 
The two targets you are most likely to use are "build-war" and "deploy." The 
build-war target compiles files and creates a WAR file that can be deployed to 
any application server. The deploy target builds the war file and automatically 
deploys the application to a Tomcat server. For the automatic deployment to 
Tomcat, you need to edit the tomcat.properties file so that it has the correct 
values for the Tomcat server url, admin username, and admin password.
There is also a global build file that can be used to build and deploy all the 
examples, with one exception. The Chapter 12 example that uses LDAP, can be 
built using the global build file, but it is deployed separately because it 
requires a running LDAP server to install properly in Tomcat. The global build 
targets are 

  build-all - builds all examples into a WAR 
  undeploy-all - undeploys all examples from Tomcat 
  deploy-all - deploys all examples (with the exception of the Chapter 12 LDAP 
  example) to Tomcat 
  clean-all - deletes all compiled files and build files 

To deploy the Chapter 12 LDAP example, you must have a running LDAP server. 
After starting the LDAP server, you can deploy the example using the Ant build 
script in the Sec04 subdirectory in the Chapter 12 directory.

These examples were built using Ant 1.6.5, and tested on Tomcat 5.0.28 and 
Tomcat 5.5.12. 


Required libraries by chapter

This section lists the libraries required for each chapter. However, the Servlet 
and JSP libraries are not listed. These libraries are supplied by your 
application server, so you configure the location and name of these libraries in 
the tomcat.properties file.

For each library, the version used to test the example is also listed. You can 
attempt to use a different library, but the application has been tested only 
with the listed version.

Chapter 01
No libraries required. 

Chapter 02
No libraries required. 

Chapter 03
No libraries required. 

Chapter 04
JSP Standard Tag Library 1.1 - Uses jstl.jar and standard.jar
Xalan 2.7.0 - Uses xalan.jar and serializer.jar

Chapter 05
JavaServer Faces 1.1.01 - Uses commons-beanutils.jar, commons-collections.jar, 
commons-digester.jar, commons-logging.jar, jsf-api.jar, and jsf-impl.jar
JSP Standard Tag Library 1.1 - Uses jstl.jar and standard.jar

Chapter 06
No libraries required. 

Chapter 07
JSP Standard Tag Library 1.1 - Uses jstl.jar and standard.jar

Chapter 08
JSP Standard Tag Library 1.1 - Uses jstl.jar and standard.jar

Chapter 09
JSP Standard Tag Library 1.1 - Uses jstl.jar and standard.jar
Hibernate 3.0.5 - Uses antlr-2.7.5H3.jar, asm.jar cglib-2.1.jar, 
commons-collections-2.1.1.jar, commons-logging-1.0.4.jar, dom4j-1.6.jar, 
ehcache-1.1.jar, hibernate3.jar, jta.jar
HSQLDB 1.8.0 - Copy hsqldb.jar to the application server's lib directory. For 
example, if you are using Tomcat, copy hsqldb.jar to Tomcat's common/lib 
directory.
Flock 0.6 - Since Flock is not bundled as a library, a flock JAR file is 
included with this download. In addition, you need the commons-lang-1.0.jar, 
jdom-1.0b8.jar, log4j-1.2.6.jar files that come with the Flock distribution.
Castor 0.9.9.1 - Uses castor-0.9.9.1.jar

Chapter 10
No libraries required. 

Chapter 11
No libraries required. 

Chapter 12
The JDBC example uses HSQLDB 1.8.0 - Copy hsqldb.jar to the application server's 
lib directory. For example, if you are using Tomcat, copy hsqldb.jar to Tomcat's 
common/lib directory. If you are using some other database, copy the JDBC driver 
library to the same location.
The LDAP example uses an ldap server for *nix or ldap server for Windows
The LDAP example also uses JNDI - Copy the ldap.jar file to the common/lib 
directory
The JAAS example uses Tagish 1.0.3 - Copy tagishauth.jar to the application 
server's lib directory. In addition, you need NTSystem.dll for Windows, which 
should be copied to the Tomcat bin directory.

Chapter 13
Uses the same libraries as Chapter 09
In addition uses OSCache 2.2 - Uses oscache-2.2.jar

Chapter 14
Tagunit 1.0.1 - Uses tagunit.jar
Cactus 1.7.1 - Uses aspectjrt-1.2.1.jar, cactus-1.7.1.jar, 
commons-httpclient-2.0.2.jar, and commons-logging-1.0.4.jar
JUnit 3.8.1 - Uses junit.jar which you need as part of the classpath for 
compiling. In addition, junit.jar should be in the Ant lib directory, so that 
the Ant junit task can be called

Chapter 15
Installation instructions are in the Chapter 15 directory of this distribution. 


Libraries required

JSP Standard Tag Library 1.1 - Used for Chapters 4, 5, 7, 8, and 9 
Xalan 2.7.0 - Used for Chapter 4

JavaServer Faces 1.1.01 - Used for Chapter 5

Hibernate 3.0.5 - Used for Chapters 9 and 13

HSQLDB 1.8.0 - Used for Chapters 9, 12, and 13

Flock 0.6 - Used for Chapters 9 and 13

Castor 0.9.9.1 - Used for Chapters 9 and 13

JNDI - Used for Chapter 12

Tagish 1.0.3 - Used for Chapter 12

OSCache 2.2 - Used for Chapter 13

Tagunit 1.0.1 - Used for Chapter 14

Cactus 1.7.1 - Used for Chapter 14

JUnit 3.8.1 - Used for Chapter 14


Libraries to be copied to server lib directory

HSQLDB 1.8.0 - The hsqldb.jar file must be copied to the server's lib directory 
for the Chapter 12 examples that access an HSQL database for authentication.

MySQL Connector/J - If you are using some other database for Chapter 12, such as 
MySQL, you need to copy the JDBC driver file (Connector/J for MySQL) to the 
server's lib directory.

JNDI - The ldap.jar file must be copied to the server's lib directory for the 
Chapter 12 example that uses ldap

Tagish 1.0.3 - The tagishauth.jar file must be copied to the server's lib 
directory for the Chapter 12 example that uses JAAS