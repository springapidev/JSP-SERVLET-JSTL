/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

import java.io.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("Welcome " + n);

            //appending the username in the query string  
            out.print("<a href='SecondServlet?uname=" + n + "'>visit</a>");

            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
