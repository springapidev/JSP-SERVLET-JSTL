/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.http.*;  
      
    public class HelloServlet extends HttpServlet {  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
          
            out.print("<br>welcome to servlet<br>");  
              
        }  
      
    }  