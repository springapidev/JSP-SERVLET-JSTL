/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

    import java.io.*;  
    import javax.servlet.http.*;  
      
    public class SecondServlet extends HttpServlet {  
      
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){  
        try{  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        Cookie ck[]=request.getCookies();  
        out.print("Hello "+ck[0].getValue());  
      
        out.close();  
      
             }catch(Exception e){System.out.println(e);}  
        }  
          
      
    }  