<html>

  <head>
    <title>Apress online store</title>
    <link rel="stylesheet" href="../projsp.css">
  </head>

  <body>

    <table width="100%">
    
      <tr>
        <td valign="top">
          <h1>Welcome</h1>
          Welcome to the Apress online store - here you can learn 
          about and buy books through our secure server.
        </td>
        <td align="right">

          <jsp:include page="box.jsp">
            <jsp:param name="color" value="#CC0033"/>
            <jsp:param name="title" value="Pro JSP 2, 4th Edition"/>
            <jsp:param name="body" value="Pro JSP 2, 4th Edition is 
            now out. It covers all of the new features of the JSP 2.1 
            specification, backed up by real-world examples that you 
            can take and adapt to your own projects.
              <br><br>
              [
                <a href=\"http://www.apress.com/book/bookDisplay.html?bID=464\">More information...</a>
              ]"/>
          </jsp:include>

          <br><br>

          <jsp:include page="box.jsp">
            <jsp:param name="color" value="#314289"/>
            <jsp:param name="title" value="Beginning Java Objects: From Concepts to Code"/>
            <jsp:param name="body" value="Among Java's many attractive 
            features as a programming language, its object-oriented 
            nature is key to creating powerful, reusable code and 
            applications that are easy to maintain and extend. To 
            take advantage of these capabilities, you're going to 
            need not only to master the syntax of the Java language, 
            but also to gain a practical understanding of what objects 
            are all about, and more importantly, how to structure a 
            Java application from the ground up to make the most of 
            objects. With Beginning Java Objects: From Concepts to 
            Code, readers will learn all three!
              <br><br>
              [
                <a href=\"http://www.apress.com/book/bookDisplay.html?bID=406\">More information...</a>
              ]"/>
          </jsp:include>

        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <br><br>
          <%@ include file="copyright.jsp" %>
        </td>
      </tr>
      
    </table>

  </body>

</html>