<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!--Jsp scriptlet tag-->
        <%
            String nam = request.getParameter("n");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String hobby = null;
            String reading = request.getParameter("reading");
            String writing = request.getParameter("writing");
            String playing = request.getParameter("playing");
            if (reading.isEmpty()) {
                hobby += request.getParameter("reading");
            }
            if (writing.isEmpty()) {
                hobby += request.getParameter("writing");
            }
            if (playing.isEmpty()) {
                hobby += request.getParameter("playing");
            }
            String country = request.getParameter("country");
            out.println("Name: " + nam);
            out.println("Email: " + email);
            out.println("Age: " + age);
            out.println("Gender: " + gender);
            out.println("Hobby: " + hobby);
            out.println("Country: " + country);


        %>
    </body>
</html>
