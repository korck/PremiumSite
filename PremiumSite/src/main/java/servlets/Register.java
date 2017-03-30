package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Workdb;
import users.User;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
		if(request.getParameter("register")!=null) {
			if (request.getParameter("password") == request.getParameter("cpassword")) {
				User user = new User(
						request.getParameter("username"),
						request.getParameter("password"),
						request.getParameter("email"),
						0
						);
				Workdb db = new Workdb();
				db.insertUser(user);
			} else response.getWriter().print("* Passwords doesn't match<br>");
		} 
		String content = "";
		content = content.concat("<form action=register method=post>"
				+ "<br>Username: <br> <input type=text id=username name=username size=3>"
				+ "<br>Password: <input type=text id=password name=password size=3>"
				+ "<br>Confirm Password: <input type=text id=cpassword name=cpassword size=3>"
				+ "<br>Email: <input type=text id=email name=email size=3>"
				+ "<br><input type=submit name=register value=Register/><br>"
				+ "</form>");
		response.getWriter().println(content);
		response.getWriter().print("</center>");
	}
}
