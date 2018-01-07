<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String u = request.getParameter("username");
            String p = request.getParameter("password");
             if (u.equals("admin") && p.equals("123456")) {
                session.setAttribute("username", u);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        %>
    </body>
</html>
