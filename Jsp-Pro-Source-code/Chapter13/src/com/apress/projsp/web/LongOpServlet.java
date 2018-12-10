
package com.apress.projsp.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A slow servlet to demonstrate the OSCache caching ServletFilter.
 */
public class LongOpServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
            
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println(
            "<!DOCTYPE HTML PUBLIC \"-//w3c//dtd html 4.0 transitional//en\">");
        pw.println("<html><head><title>Long operation Servlet</title></head>");
        pw.println("<body>");      
        pw.println("<h1>Long operation Servlet</h1> "); 
        try {            
            Thread.sleep(3000);            
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }        
        pw.println("<p>Woke up at: "+new java.util.Date().toString()+"</p>");
        pw.println("<p>The reason this page took so long to load is because ");
        pw.println("it contains a 10 second sleep.</p> ");        
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();    }
}
