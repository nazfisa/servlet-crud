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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	// HttpServlet is a base class for handling Http request and providing response
	// doPost method handles the POST request
	// request object provides the access to the request information for HTTP servlets
	// can write information about the data it will send back.
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// getParameter() -> to retrieve the input values from HTML page
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		String fullname= request.getParameter("fullname");
		String password= request.getParameter("password");
		String phone= request.getParameter("phone");
		String address= request.getParameter("address");
		
		User e = new User();
		e.setUsername(username);
		e.setEmail(email);
		e.setFullname(fullname);
		e.setPassword(password);
		e.setPhone(phone);
		e.setAddress(address);
		int status = UserDao.save(e);
		if(status>0) {
			out.print("<p> Record Saved Successfully</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else {
			out.print("Sorry ! Unable to save record");
		}
		out.close();
	}
	
}
