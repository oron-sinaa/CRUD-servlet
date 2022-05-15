import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.dao.UserDao;
import com.aakash.model.User;

@WebServlet("/save-user")
public class SaveUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("user_name");
		/*
		String id=req.getParameter("user_id");
		int changedId=Integer.parseInt(id);
		*/
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		int save=UserDao.addUser(user);
		if(save>0)
		{
			resp.sendRedirect("user-display");
		}
		else
		{
			out.print("<p style='color:red'>data not saved!!</p>");
			req.getRequestDispatcher("/").include(req,resp);
		}
		
	}
}
