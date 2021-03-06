package servlets;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
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
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute("permission").toString() != "1" ||
			session.getAttribute("permission").toString() != "2"	
				) {
			response.sendRedirect("verbotten.jsp");
			return;
		}
		chain.doFilter(request, response);
	}
	
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
				//session.setAttribute("permission", user.getPermissions());
				session.setAttribute("permission", "1");
				RequestDispatcher rd = request.getRequestDispatcher("profile");
				rd.forward(request,response);
			}
		} else {
			response.sendRedirect("index.jsp");
		}
		response.getWriter().print("</center>");
	}
}
