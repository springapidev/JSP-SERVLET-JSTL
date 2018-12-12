<%-- 
    Document   : index
    Created on : Dec 17, 2017, 1:00:19 AM
    Author     : Rajail Islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${'${'}10}
          <table border="1">
      <tr>
        <td><b>Concept</b></td>
        <td><b>EL Expression</b></td>
        <td><b>Result</b></td>
      </tr>    
      <tr>
        <td>Literal</td>
        <td>${'${'}10}</td>
        <td>${10}</td>
      </tr>    
      <tr>
        <td>Addition</td>
        <td>${'${'}10 + 10 }</td>
        <td>${10 + 10}</td>
      </tr>  
      <tr>
        <td>Subtraction</td>
        <td>${'${'}10 - 10 }</td>
        <td>${10 - 10}</td>
      </tr>    
      <tr>
        <td>Multiplication</td>
        <td>${'${'}10 * 10 }</td>
        <td>${10 * 10}</td>
      </tr>    
      <tr>
        <td>Division / </td>
        <td>${'${'}10 / 3 }</td>
        <td>${10 / 3}</td>
      </tr>    
      <tr>
        <td>Division DIV</td>
        <td>${'${'}10 div 3 }</td>
        <td>${10 div 3}</td>
      </tr>    
      <tr>
        <td>Modulus</td>
        <td>${'${'}10 % 3 }</td>
        <td>${10 % 3}</td>
      </tr>    
      <tr>
        <td>Modulus</td>
        <td>${'${'}10 mod 3 }</td>
        <td>${10 mod 3}</td>
      </tr>    
      <tr>
        <td>Precedence</td>
        <td>${'${'}2 * 5 mod 3 }</td>
        <td>${2 * 5 mod 3}</td>
      </tr>
      <tr>
        <td>Precedence with parens</td>
        <td>${'${'}2 * (5 mod 3) }</td>
        <td>${2 * (5 mod 3)}</td>
      </tr>
      <tr>
        <td>Division by Zero</td>
        <td>${'${'}10 / 0 }</td>
        <td>${10 / 0}</td>
      </tr>    
      <tr>
        <td>Exponential</td>
        <td>${'${'}2E2}</td>
        <td>${2E2}</td>
      </tr>  
      <tr>
        <td>Unary Minus</td>
        <td>${'${'}-10}</td>
        <td>${-10}</td>
      </tr>    
    </table>
    </body>
</html>
