package com.RocketTeam.Web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Auth")
public class Auth extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("usuario");
		if (user != "") {
			response.addCookie(new Cookie("usuario", user));
		}
		for (Cookie c : request.getCookies()) {
			if (c.getName().equals("usuario") && c.getValue() != "") {
				response.sendRedirect("./Dashboard");
				return;
			}
		}
		response.sendRedirect("./Login");
	}
	
}
