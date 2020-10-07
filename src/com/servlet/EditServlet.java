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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Update User</h3>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		User u = UserDao.getInfoById(id);
		out.println("<form action='UpdateServlet' method='POST'>");
		out.println("<table>");
		out.println("<tr><td></td><td><input type='hidden' name='id' value='"+u.getId()+"' /></td></tr>");
		out.println("<tr><td>User Name : </td><td><input type='text' name='username' value='"+u.getUsername()+"' /></td></tr>");
		out.println("<tr><td>Email : </td><td><input type='text' name='email' value='"+u.getEmail()+"' /></td></tr>");
		out.println("<tr><td>Full Name : </td><td><input type='text' name='fullname' value='"+u.getFullname()+"' /></td></tr>");
		out.println("<tr><td>Password : </td><td><input type='text' name='password' value='"+u.getPassword()+"' /></td></tr>");
		out.println("<tr><td>Phone : </td><td><input type='text' name='phone' value='"+u.getPhone()+"' /></td></tr>");
		out.println("<tr><td>Address : </td><td><input type='text' name='address' value='"+u.getAddress()+"' /></td></tr>");
		out.println("<tr><td colspan='2'><input type='submit'  value='Update' /></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
	}
}
