package com.servlet;



import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet  extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		User u = new User();
		u.setId(id);
		UserDao.delete(u);
		response.sendRedirect("ViewServlet");
	}
	

}
