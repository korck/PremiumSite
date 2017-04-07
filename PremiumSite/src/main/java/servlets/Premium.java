package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Workdb;
import users.User;

@WebServlet("/premium")
public class Premium extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
		String content = "";
		content = content.concat("★ Premium ★");
		
		response.getWriter().println(content);
		response.getWriter().print("</center>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<center>");
		
		String content = "";
		content = content.concat("★ Premium ★");
		
		response.getWriter().println(content);
		response.getWriter().print("</center>");
	}
}
