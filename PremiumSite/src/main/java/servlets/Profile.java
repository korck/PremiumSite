package servlets;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Workdb;
import users.User;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute("permission").toString() != "0" ||
			session.getAttribute("permission").toString() != "1" ||
			session.getAttribute("permission").toString() != "2"
				) {
			response.sendRedirect("login.jsp");
			return;
		}
		if (session.getAttribute("permission") == "1" ||
			session.getAttribute("permission") == "2"
			) {
			response.getWriter().println(""
					+ "<form action=premium method=get>"
					+ "<input type=submit name=premium value=Premium>"
					+ "</form>");
		}
		chain.doFilter(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		if(request.getParameter("login")!=null) {
			Workdb db = new Workdb();
			User user = new User();
			user = db.findUser(
					request.getParameter("username"),
					request.getParameter("password")
					);
			if (user == null) {
				response.sendRedirect("login.jsp");
			} else {
				//session.setAttribute("username", user.getUsername());
				//session.setAttribute("permission", user.getUsername());
				response.getWriter().println("<h1>Hello, "
						+ session.getAttribute("username")
						//+ user.getUsername()
						+ session.getAttribute("permission")
						+ "</h1>");
			}
		} else {
			response.sendRedirect("index.jsp");
		}
		response.getWriter().print("</center>");
	}
}
