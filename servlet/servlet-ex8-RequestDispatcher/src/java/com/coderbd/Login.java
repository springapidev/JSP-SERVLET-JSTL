/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

    import java.io.*;  
    import javax.servlet.*;  
    import javax.servlet.http.*;  
      
      
    public class Login extends HttpServlet {  
      
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("userName");  
        String p=request.getParameter("userPass");  
              
        if(p.equals("servlet")){  
            RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
            rd.forward(request, response);  
        }  
        else{  
            out.print("Sorry UserName or Password Error!");  
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.include(request, response);  
                          
            }  
        }  
      
    }  


/*
The RequestDispatcher interface provides the facility of dispatching the request to another resource it may be html, servlet or jsp. This interface can also be used to include the content of another resource also. It is one of the way of servlet collaboration.

There are two methods defined in the RequestDispatcher interface.

Methods of RequestDispatcher interface

The RequestDispatcher interface provides two methods. They are:

    public void forward(ServletRequest request,ServletResponse response)throws ServletException,java.io.IOException:Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
    public void include(ServletRequest request,ServletResponse response)throws ServletException,java.io.IOException:Includes the content of a resource (servlet, JSP page, or HTML file) in the response.

*/