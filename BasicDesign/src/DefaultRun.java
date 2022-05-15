import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DefaultRun extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
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
		out.print("<a href='user-display'>View Data</a>");
		out.print("<br>");
		out.print("<form action='save-user' method='post'>");
		out.print("<div class='form-group'>");
		out.print("<label for='user_name'>User Name</label>");
		out.print("<input type='text' name='user_name' class='form-control' placeholder='Enter User Name'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='user_email'>User Email</label>");
		out.print("<input type='text' name='user_email' class='form-control' placeholder='Enter User Email'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='user_password'>User Password</label>");
		out.print("<input type='text' name='user_password' class='form-control' placeholder='Enter User Name'>");
		out.print("</div>");
		out.println("<button type='submit' class='btn btn-primary'>Add Data</button>");
	}
}
