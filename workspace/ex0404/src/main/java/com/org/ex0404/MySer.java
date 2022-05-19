package com.org.ex0404;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySer extends HttpServlet {

	public MySer() {
		System.out.println("MySer 생성자...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		resp.setContentType("text/html");
		System.out.println("일로온다....");
	}
	
}
