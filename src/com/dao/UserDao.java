package com.dao;



import com.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	//Database connection
	public static Connection getConnection() {
		Connection con = null;
				String url= "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
				String user="asifRcode";
				String password="asifRcode";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url, user, password);
			System.out.println("Database connected...");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	//Data Insert into user table
	public static int save(User e) {
		int status=0;
		try {
			Connection connection = UserDao.getConnection();
			String sql="INSERT INTO user (username,email,fullname,password,phone,address) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement p = connection.prepareStatement(sql);
			
			p.setString(1, e.getUsername());
			p.setString(2, e.getEmail());
			p.setString(3, e.getFullname());
			p.setString(4, e.getPassword());
			p.setString(5, e.getPhone()); ;
			p.setString(6, e.getAddress());
			
			 status = p.executeUpdate();
			 connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
		
	}
	public static List<User> getAll(){
		List<User> list = new ArrayList<User>();
		try {
			Connection conection = UserDao.getConnection();
			String sql="SELECT * FROM user";
			PreparedStatement p = conection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setFullname(rs.getString(5));
				
				u.setPhone(rs.getString(6));
				u.setAddress(rs.getString(7));
				
				list.add(u);
				
				
			}
			conection.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	public static int delete(User u) {
		int status = 0;
		try {
			Connection connection = UserDao.getConnection();
			String sql = "DELETE FROM user WHERE id=?";
			PreparedStatement p = connection.prepareStatement(sql);
			p.setInt(1, u.getId());
			status = p.executeUpdate();
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static User getInfoById(int id) {
		User u = new User();
		int status =0;
		try {
			Connection connection = UserDao.getConnection();
			String sql = "SELECT * FROM user WHERE id=?";
			PreparedStatement p = connection.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setFullname(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setPhone(rs.getString(6));
				u.setAddress(rs.getString(7));
			}
			status = p.executeUpdate();
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return u;
		
	}
	
	 public static int update(User u) {
		 int status = 0;
		 try {
			 Connection connection = UserDao.getConnection();
			 String sql = "update user set username=?,email=?,fullname=?,password=?,phone=?,address=? where id=?";
			 PreparedStatement p = connection.prepareStatement(sql);
			 p.setString(1, u.getUsername());
			 p.setString(2, u.getEmail());
			 p.setString(3, u.getFullname());
			 p.setString(4, u.getPassword());
			 p.setString(5, u.getPhone());
			 p.setString(6, u.getAddress());
			 p.setInt(7, u.getId());
			 
			 status= p.executeUpdate();
			 connection.close();
			 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return status;
	 }
	
	
	
	}
