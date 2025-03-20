package com.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

import com.dao.UserDao;

@WebFilter("/UserFilter")
public class UserFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		System.out.println("Filter Destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean flag=UserDao.checkEmaail(request.getParameter("email"));
		if(flag==false)
		{
			if(request.getParameter("password").equals((request.getParameter("cpassword"))))
		     {
				chain.doFilter(request, response);
			 }
			else
			{
				request.setAttribute("msg", "Password & Confirm Does Not Matched");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
	    }
		else
		{
			request.setAttribute("msg", "Email Alredy Registered");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	  System.out.println("Filter Intialized");
	}

}
