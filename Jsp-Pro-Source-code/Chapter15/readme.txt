Professional JSP 2, 4th EditionChapter 15 Struts
The struts example from Chapter 15 has its own separate download. This page 
lists the steps needed to download, install and run the example on your system.
Using the bin distribution
  Download struts-resume bin distribution. 
  Download tomcat-5-jars. (Assuming you are using Tomcat. You may need these 
  jars for other servers, as well.) 
  Unpack the struts-resume zip file to a directory of your choosing 
  Unpack the tomcat-5-jars jar file and copy the three jar files to the Tomcat 
  common/lib directory. 
  The struts-resume application uses MySQL as its database. If not already 
  running, start your MySQL server. 
  If you used MySQL for any of the examples in Chapter 9, you already have a 
  copy of the MySQL JDBC driver library. If not, download the Connector/J driver 
  library. Copy the driver JAR file to the Tomcat common/lib directory. 
  Login to the server as the root user. To make the next step easier, run the 
  MySQL client (mysql) from the same directory where you unpacked the 
  struts-resume zip file. 
  Use the resume.sql script to initialize the database. This can be done by 
  executing the command 'source resume.sql' from the mysql command line. 
  Log out of MySQL by quitting the MySQL client 
  Verify you can login to the new database by executing "mysql -u test -p 
  resume". The password will be "test". After logging in, you can verify that 
  data was loaded into the tables by executing 'show tables' to list the tables, 
  and executing 'select * from table_name' with various table names to view the 
  data. Quit the MySQL client. 
  Copy the struts-resume.war file to the Tomcat webapps directory. 
  If Tomcat is running, it should deploy the application. If Tomcat is not 
  running, Tomcat will deploy the application when you start Tomcat. 
  Open a browser and access the struts-resume application with the URL 
  http://localhost:8080/struts-resume 
  If you want to view an existing resume, login with the username/password 
  tomcat/tomcat. Otherwise, use the Signup link near the bottom of the login 
  screen to create a new account. 
Using the src distribution
  Download struts-resume src distribution. 
  Unpack the struts-resume zip file to a directory of your choosing 
  Download tomcat-5-jars. (Assuming you are using Tomcat. You may need these 
  jars for other servers, as well.) 
  Unpack the tomcat-5-jars jar file and copy the three jar files to the Tomcat 
  common/lib directory. 
  Download the Tomcat deployer application. Unpack it and copy catalina-ant.jar 
  to the ant lib directory. (If you are using Tomcat 5.0, find and use the 
  appropriate download for your version of Tomcat.) 
  Download Sun's Java EE SDK (unless you already have a copy) and copy j2ee.jar 
  to the struts-resume lib\j2sdkee1.4\lib directory 
  Run the ant task setup-db. 
  Verify you can login to the new database by executing "mysql -u test -p 
  resume". The password will be "test". After logging in, you can verify that 
  data was loaded into the tables by executing 'show tables' to list the tables, 
  and executing 'select * from table_name' with various table names to view the 
  data. Quit the MySQL client. 
  Copy the struts-resume test/applicationContext-database.xml file to the 
  struts-resume directory. (Or, if you are using Linux/solaris/Unix, create a 
  link to the file) 
  Copy the struts-resume 
  src/dao/org/appfuse/persistence/hibernate/applicationContext-hibernate.xml 
  file to the struts-resume directory. (Or, if you are using Linux/solaris/Unix, 
  create a link to the file) 
  Copy the struts-resume 
  src/service/org/appfuse/service/applicationContext-service.xml file to the 
  struts-resume directory. (Or, if you are using Linux/solaris/Unix, create a 
  link to the file) 
  You can test that the db access code works by running 'ant test-dao 
  -Dtestcase=UserDAOTest' and 'ant test-service -Dtestcase=UserManagerTest' 
  Ensure that the CATALINA_HOME env variable is set to the correct location of 
  the Tomcat installation. 
  Compile and deploy the application using 'ant setup-tomcat deploy'. If you are 
  using JDK 1.5, you will need to modify the build.xml file or the 
  RequestUtil.java file. This source file uses 'enum' as a variable name, and 
  'enum' is reserved in JDK 1.5. Rename 'enum' in the source file, to compile 
  with JDK 1.4. 
  The previous step creates a file named 'struts-resume.xml' and copies it to 
  the Tomcat webapps directory. Find this file and move it to the Tomcat 
  conf/Catalina/localhost directory. 
  The setup and deploy step also copies a MySQL JDBC driver library to Tomcat 
  common/lib. If you already have a newer version of the MySQL JDBC driver, you 
  can delete the older JAR file mysql-connector-java-3.0.11-stable-bin.jar. 
  Restart Tomcat, or using the Tomcat Manager Application, reload struts-resume. 

  Open a browser and access the struts-resume application with the URL 
  http://localhost:8080/struts-resume 
  If you want to view an existing resume, login with the username/password 
  tomcat/tomcat. Otherwise, use the Signup link near the bottom of the login 
  screen to create a new account. 
