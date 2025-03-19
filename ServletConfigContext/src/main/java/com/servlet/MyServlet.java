package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String email,driver;
	 ServletConfig config;
	 ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init");
		this.config=config;
		this.context=config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       response.setContentType("text/html");
		
	   System.out.println("deGet");
       email=config.getInitParameter("email");
       System.out.println("Email :"+email);
       out.println("Email :"+email);
       
       driver=context.getInitParameter("driver");
       System.out.println("driver :"+driver);
       out.println("Email :"+driver);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("DoPost");
	}
	@Override
	public void destroy() {
	   System.out.println("Destroy");
	}

}
