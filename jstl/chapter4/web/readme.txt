Pro JSP - Chapter 4, JSTL

Before these examples will run in Tomcat you need to make sure you 
have the JSTL installed. Refer to page 132-133 of the book for further 
instructions on what it required.

In order to get the xml library examples to run you need to make sure 
you are using the JAXP libraries from JDK 1.4.1 or above.

The JWSDP kit comes with updates versions which you can run in Tomcat 
by creating a JAVA_OPTs variable with the following value:

> JAVA_OPTS=-Djava.endorsed.dirs=%JWSDP_HOME%/jaxp/lib/endorsed

where %JWSDP_HOME% is the root of where you have installed the Java Web 
Services Developer Pack