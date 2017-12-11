/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

    import java.io.*;  
    import javax.servlet.*;  
    import javax.servlet.http.*;  
      
    public class WelcomeServlet extends HttpServlet {  
      
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("userName");  
        out.print("Welcome "+n);  
        }  
      
    }  