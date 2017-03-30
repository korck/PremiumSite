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

@WebServlet("/upgrade")
public class Upgrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("permission").toString() != "2") {
			response.sendRedirect("index.jsp");
		} else {
			Workdb db = new Workdb();
			db.upgradeUser(request.getParameter("name"));
		}
		response.getWriter().print("</center>");
	}
}
