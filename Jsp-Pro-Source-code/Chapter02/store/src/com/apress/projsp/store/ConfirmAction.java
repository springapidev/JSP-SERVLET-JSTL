package com.apress.projsp.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


public class ConfirmAction implements Action {
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		return "/confirmed.html";
	}
}
