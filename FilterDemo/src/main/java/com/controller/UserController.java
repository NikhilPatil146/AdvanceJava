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
              
              if(action.equalsIgnoreCase("register"))
              {
            	  User u=new User();
            	  u.setFname(request.getParameter("fname"));
            	  u.setLname(request.getParameter("lname"));
            	  u.setEmail(request.getParameter("email"));
            	  u.setMobile(Long.parseLong(request.getParameter("mobile")));
            	  u.setPassword(request.getParameter("password"));
            	  UserDao.registerUser(u);
            	  request.setAttribute("msg","User Registered Successfully");
            	  request.getRequestDispatcher("register.jsp").forward(request, response);
              }
              else if(action.equalsIgnoreCase("login"))
              {
            	    User u=UserDao.loginUser(request.getParameter("email"));
            	    if(u!=null)
            	    {
            	    	if(u.getPassword().equals(request.getParameter("password")))
            	    	{
            	    		
            	    	}
            	    	else
            	    	{
            	    	  request.setAttribute("msg","Incorrect Password");
                       	  request.getRequestDispatcher("login.jsp").forward(request, response);
            	    	}
            	    }
            	    else 
            	    {
            	    	request.setAttribute("msg","Email Not Registered");
                     	  request.getRequestDispatcher("login.jsp").forward(request, response);
            	    	
            	    }
              }
	}

}





         

















//


