<html>
  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
		<h2>Chapter 14 - Design and Best Practices</h2>
		<hr />
		
		<p>Chapter 14 starts with a review of several design 
		patterns. Rather than repeat the (incomplete) code 
		from the Chapter 14, 
		here are actual examples of the same concepts using
		examples from Chapter 9.</p>
		
		<p>Front Controller - The RSS Reader example from 
		Chapter 9 used a Front Controller. The class was 
		named simply <a href="source.jsp?name=Controller.java">Controller.java</a>.
		</p>

		<p>Action Interface - The RSS Reader example from 
		Chapter 9 used the Action interface. The class was 
		named simply <a href="source.jsp?name=Action.java">Action.java</a>.
		However, unlike the interface shown in Chapter 14, this interface
		defined the action method to be <code>doGet()</code>. The 
		Controller gets an Action instance, then calls the its 
		<code>doGet()</code> method.
		</p>
		
		<p>Action Implementation - The RSS reader example provided three
		classes that implemented the Action interface. One of them was the 
		<a href="source.jsp?name=LoginAction.java">LoginAction.java</a> 
		class. This class illustrates another difference between Chapter 9
		and Chapter 14. In Chapter 14, the example shows the action 
		implementation returning the path to the JSP and the controller 
		forwards the request to the JSP. However, in Chapter 9, the design
		decision was made to have the action implementation be responsible 
		forwarding the request to the view component. You can see that in
		LoginAction.java.		
		</p>

		<p>In the section on Testing, a number of Test frameworks were
		summarized. The standard framework for testing regular Java classes
		is <a href="http://www.junit.org">JUnit</a>. As a trivial example,
		the class 
		<a href="source.jsp?name=test/com/apress/projsp/CustomerTest.java">CustomerTest.java</a>
		can be used to test the class 
		<a href="source.jsp?name=src/com/apress/projsp/Customer.java">Customer.java</a>.
		If you are using Ant, ensure junit.jar is in the Ant lib directory.
		Then you can run the test class using the target run-customer-test.
		</p>

    <p>Another test framework that was looked at was TagUnit for testing
    JSP custom tags. The page 
    <a href="source.jsp?name=test/emailAddressFilter/testEmailAddressFilter.jsp">testEmailAddressFilter.jsp</a>
    uses TagUnit to test the Email Address Filter tag from Chapter 7.
    The page <a href="source.jsp?name=test/index.jsp">test/index.jsp</a>
    tests the tag library that holds the tag. The test is run by calling
    the URL <a href="http://localhost:8080/ProJSP_Ch14/test/servlet/RunTests?uri=/test/index.jsp">http://localhost:8080/ProJSP_Ch14/test/servlet/RunTests?uri=/test/index.jsp</a>
  </body>
</html>
