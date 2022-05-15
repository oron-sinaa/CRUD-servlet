package com.aakash.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aakash.model.User;

public class UserDao {

	public static Connection getConnect()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basic","database username","database password");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	//method for storing data in database
	public static int addUser(User user)
	{
		int save=0;
		try {
			Connection con=UserDao.getConnect();
			PreparedStatement ps=con.prepareStatement("INSERT INTO demo_user(user_name,user_email,user_pass) values(?,?,?)");
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			save=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return save;
	}
	
	public static ArrayList<User> getAllUsers()
	{
		ArrayList<User> list=new ArrayList<User>();
		try {
			
			Connection con=UserDao.getConnect();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM demo_user");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User user=new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                user.setEmail(rs.getString("user_email"));
                user.setPassword(rs.getString("user_pass"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return list;
	}
	
}















