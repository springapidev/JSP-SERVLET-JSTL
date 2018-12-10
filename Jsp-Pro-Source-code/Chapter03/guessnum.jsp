<jsp:useBean id="randomNum" class="com.apress.projsp.RandomNum" scope="session"/>
<%
  if (request.getParameter("Reset") != null) {
    randomNum.reset();
  }
%>
<html>
  <head>
    <title>Guess the Number Game</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
    <h2>EL Conditions Guess the Number</h2>
    <table border="0">
      <tr>
        <td colspan="2">Was your guess too <b>Small?</b> ${randomNum.num gt param.guess}</td>
      </tr>    
      <tr>
        <td colspan="2">Was your guess too <b>Big?</b> ${randomNum.num lt param.guess}</td>
      </tr>    
      <tr>
        <td colspan="2">Was your guess <b>Correct?</b> ${randomNum.num eq param.guess}</td>
      </tr>    

      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>    
      <tr>
        <td colspan="2">I'm thinking of a number between 1 and 10.</td>
      </tr>
      <form action="guessnum.jsp" method="post">
      <tr>
        <td>What is it?</td>
        <td><input type="text" name="guess">&nbsp;&nbsp;<input type="submit"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" name="Reset" value="Reset Game"</td>
      </tr>
      </form>
    </table>
  </body>
</html>