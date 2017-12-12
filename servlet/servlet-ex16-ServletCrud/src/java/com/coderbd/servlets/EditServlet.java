/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.servlets;

import com.coderbd.domain.Student;
import com.coderbd.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rajail Islam
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentService studentService = new StudentService();
        String nam = request.getParameter("name");
        int ids = 0;
        if (request.getParameter("id") != null) {
            ids = Integer.parseInt(request.getParameter("id"));
        }
        Student student = new Student(ids, nam);
        studentService.update(student);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='EditServlet' method='post'>");
            out.println("<input type='text' name='id'/>");
            out.println("<input type='text' name='name'/>");
            out.println("<input type='submit' value='Update'/>");

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    }
}
