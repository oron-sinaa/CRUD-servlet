import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.dao.UserDao;
import com.aakash.model.User;

@WebServlet("/user-display")
public class UserDisplay extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		ArrayList<User> list=UserDao.getAllUsers();
		out.println("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Basic Form</title>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		out.print("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class='container'>");
		out.print("<h1>Users Data</h1>");
		out.print("<table class='table table-striped'>");
		out.print("<tr>");
		out.print("<th>User Id</th>");
		out.print("<th>User Name</th>");
		out.print("<th>User Email</th>");
		out.print("<th>User Password</th>");
		out.print("</tr>");
		
		for(User u:list)
		{
			out.print("<tr>");
			out.print("<td>"+u.getId()+"</td>");
			out.print("<td>"+u.getName()+"</td>");
			out.print("<td>"+u.getEmail()+"</td>");
			out.print("<td>"+u.getPassword()+"</td>");
			out.print("</tr>");
		}
	
	}
}
