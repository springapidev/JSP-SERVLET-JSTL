/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        PrintWriter out = null;
        try {
            response.setContentType("text/html");
            out = response.getWriter();
            //getting value from the query string
            String n = request.getParameter("uname");
            out.print("Hello " + n);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SecondServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

}
