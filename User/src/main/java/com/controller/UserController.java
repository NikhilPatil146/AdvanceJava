package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String action=request.getParameter("action");
	    if(action.equalsIgnoreCase("insert"))
	    {
		User u=new User();
	    u.setFname(request.getParameter("fname"));
	    u.setLname(request.getParameter("lname"));
	    u.setEmail(request.getParameter("email"));
	    u.setMobile(request.getParameter("mobile"));
	    u.setDob(request.getParameter("dob"));
	    u.setGender(request.getParameter("gender"));
	    u.setPas(request.getParameter("pas"));
	    UserDao.insertUser(u);
	    System.out.println("Data Insert Successfully");
	    response.sendRedirect("show.jsp");
	    }
	    else if(action.equalsIgnoreCase("delete"))
	    {
	    	int u_id=Integer.parseInt(request.getParameter("u_id"));
	    	UserDao.deleteUser(u_id);
		    response.sendRedirect("show.jsp");
	    }
	}
}
