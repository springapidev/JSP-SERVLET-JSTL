<jsp:useBean id="person" class="com.coderbd.Person">
    <jsp:setProperty name="person" property="*"/>

</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${person.name}
        ${person.age}
        ${person.email}

        <form action="simpleBean.jsp">
            <input type="text" name="name">
            <input type="email" name="email">
              <input type="text" name="age">
            <input type="submit" name="Send">

        </form>
    </body>
</html>
