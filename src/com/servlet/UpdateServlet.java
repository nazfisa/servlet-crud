package com.servlet;


import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		User u = new User();
		u.setId(id);
		u.setUsername(username);
		u.setEmail(email);
		u.setFullname(fullname);
		u.setPassword(password);
		u.setPhone(phone);
		u.setAddress(address);
		 
		int status = UserDao.update(u);
		if(status>0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.println("Sorry! Unable to update record");
		}
		
	}
	
}
