package com.controllers;
//package com.classes;
import com.classes.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext factory =new ClassPathXmlApplicationContext("bean.xml");
		Employee obj =(Employee)factory.getBean("Employee");
		
	//	Object obj1 = ctx.getBean("Employee");
		obj.setEname(request.getParameter("t2")); 
		obj.setRole(request.getParameter("t3"));
		String sal = request.getParameter("t4");
		
		obj.setSalary(Double.parseDouble(sal));
	
		obj.setUsername(request.getParameter("t5"));
		obj.setPassword(request.getParameter("t6"));
		
		
		/*
		 * String name = request.getParameter("t3"); String address =
		 * request.getParameter("t4"); String Phone_Number = request.getParameter("t5");
		 * String uname = request.getParameter("t1"); String pwd =
		 * request.getParameter("t2");
		 */

		PrintWriter out = response.getWriter();
		//JbeanDb db = new JbeanDb();
        EmpDao in = new EmpDao();
        in.insert(obj);
		//db.insert(name, address, Phone_Number, uname, pwd);
        
		if(obj.getId()!=0){

			 // out.println("<h2></h2>");
			 // request.setAttribute("name", name); 
		//	  RequestDispatcher rd =request.getRequestDispatcher("Dashboard.jsp"); 
			 // rd.forward(request, response);
			 
			  String message = "Employee added successsfully";
			  request.setAttribute("message", message);
			  RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			  rd.forward(request, response);
			  
			 
		}
		else {
				  out.println("<h2>Employee adding fail</h2>");
				 // request.setAttribute("name", name); 
				   RequestDispatcher rd =request.getRequestDispatcher("Dashboard.jsp"); 
				   rd.forward(request, response);
		
		}

	}

}
