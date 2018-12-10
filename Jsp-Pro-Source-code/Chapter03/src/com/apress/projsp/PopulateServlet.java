package com.apress.projsp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PopulateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {

		Person p = new Person();
		p.setName("Sam Dalton");
		p.setAge(26);

		Address a = new Address();
		a.setLine1("221b Baker Street");
		a.setTown("London");
		a.setCounty("Greater London");
		a.setPostcode("NW1 1AA");

		ArrayList al = new ArrayList();
		PhoneNumber ph = new PhoneNumber();
		ph.setStd("01895");
		ph.setNumber("678901");
		
		al.add(ph);
		
		ph = new PhoneNumber();
		ph.setStd("0208");
		ph.setNumber("8654789");		
		al.add(ph);
		a.setPhoneNumbers(al);
		
		p.setAddress(a);

		req.setAttribute("person", p);

		RequestDispatcher rd = req.getRequestDispatcher("complexbean.jsp");
		rd.forward(req, res);

	}
}
