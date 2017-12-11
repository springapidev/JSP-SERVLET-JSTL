/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;
    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.*;  
      
    public class MyFilter implements Filter{  
    FilterConfig config;  
      
    @Override
    public void init(FilterConfig config) throws ServletException {  
        this.config=config;  
    }  
      
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
        PrintWriter out=resp.getWriter();  
              
        String s=config.getInitParameter("construction");  
              
        if(s.equals("yes")){  
             out.print("This page is under construction");  
        }  
        else{  
             chain.doFilter(req, resp);//sends request to next resource  
        }  
              
    }  
    @Override
    public void destroy() {}  
    }  