package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Workdb;
import users.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
		if(request.getParameter("login")!=null) {
			Workdb db = new Workdb();
			User user = new User();
			user = db.findUser(
					request.getParameter("username"),
					request.getParameter("password")
					);
			if (user == null) {
				response.getWriter().print("Username doesn't exists or wrong passowrd");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				session.setAttribute("permission", user.getUsername());
			}
		} else {
			response.sendRedirect("index.jsp");
		}
		response.getWriter().print("</center>");
	}
}
