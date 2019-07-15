package com.controllers;

import com.classes.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcomeServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorised access</h1>");
		pw.println("<h3>Please <a href='login.html'>login</a>first</h3>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("t1");
		String pwd = request.getParameter("t2");
		
		PrintWriter out = response.getWriter();
		JbeanDb db = new JbeanDb();
		
		
		  if(db.check(name, pwd)) {
		  out.println("<h1>Successfully logged<h1>");
		  request.setAttribute("name", name); 
		  RequestDispatcher rd =request.getRequestDispatcher("Dashboard.jsp"); 
		  rd.include(request, response);
		 
		  }
		  
		  else { out.println("<h1>Invalid Credentials<h1>");
		  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		  rd.include(request, response);
		  //out.println("<h3>To try again <a href='login.html'>Click here</a></h3>"); }
		 
	}

}
}
