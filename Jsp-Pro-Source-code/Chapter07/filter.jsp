<html>

  <head>
    <title>Professional JSP 2, 4th Edition</title>
    <link rel="stylesheet" href="projsp.css">
  </head>

  <body>

    <%@ taglib uri="/WEB-INF/tlds/ch07.tld" prefix="ch07" %>

    <%
      pageContext.setAttribute("name", "Simon Brown");
      pageContext.setAttribute("emailAddress", "simon@simongbrown.com");
      pageContext.setAttribute("subject", "Help with custom tags needed");
      pageContext.setAttribute("message", "This is my first message to the mailing list - can anybody help me understand how custom tags work, please?");
    %>

    <table>
    <ch07:emailAddressFilter>
      <tr>
        <td><h1>${subject}</h1></td>
      </tr>
      <tr>
        <td><b>From : </b>${name} (${emailAddress})</td>
      </tr>
      <tr>
        <td>${message}</td>
      </tr>
      <tr>
        <td><br><br><input type="submit" value="Reply"></td>
      </tr>
    </ch07:emailAddressFilter>
    <table>
    
  </body>

</html>