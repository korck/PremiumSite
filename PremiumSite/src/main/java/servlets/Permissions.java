package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Workdb;
import users.User;

@WebServlet("/permissions")
public class Permissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute("permission").toString() != "2") {
			response.sendRedirect("verbotten.jsp");
			return;
		}
		chain.doFilter(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
			Workdb db = new Workdb();
			ArrayList<User> users = db.getAllUsers();
			response.getWriter().println("<h1>Upgrade to premium</h1>");
			response.getWriter().println("<table>");
			response.getWriter().println("<tr>"
					+ "<th>Username</th>"
					+ "<th>Permissions</th>"
					+ "<th>Give premium</th>"
					+ "</tr>");
			for(User user : users) {
				response.getWriter().println("<tr>");
				response.getWriter().println("<td>"+user.getUsername()+"</td>");
				response.getWriter().println("<td>"+user.getPermissions()+"</td>");
				response.getWriter().println(""
						+ "<td>"
						+ "<form action=upgrade method=post name="+user.getUsername()+">" 
						+ "<input type=submit value=Upgrade>"
						+ "</form>"
						+"</td>");
				response.getWriter().println("</tr>");
			}
			response.getWriter().println("</table>");
		response.getWriter().print("</center>");
	}
}
