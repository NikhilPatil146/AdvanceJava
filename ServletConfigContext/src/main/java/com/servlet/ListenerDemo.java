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

@WebServlet("/ListenerDemo")
public class ListenerDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   ServletContext context=null;	
   public void init(ServletConfig config) throws ServletException {
	  context=config.getServletContext();
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	int counter=1;
	if(context.getAttribute("counter")!=null) 
	{
		counter=Integer.parseInt(context.getAttribute("counter").toString());
		counter++;
	}
	context.setAttribute("counter", counter);
	out.println("You Are "+counter+" Number of Visitor");
	}


}
