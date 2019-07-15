package com.controllers;
import com.classes.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class UpdateServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String id = request.getParameter("t9");
		ApplicationContext factory =new ClassPathXmlApplicationContext("bean.xml");
		Employee obj =(Employee)factory.getBean("Employee");
		EmpDao emp = new EmpDao();
		Employee result=emp.search(id);
		System.out.println("====="+id);
		PrintWriter out = response.getWriter();
		if(result!=null) {
			//emp.update();
			request.setAttribute("Name", result.getEname());
			request.setAttribute("Id", id);
			request.setAttribute("Salary", result.getSalary());
			request.setAttribute("Role", result.getRole());
			request.setAttribute("Username", result.getUsername());
			request.setAttribute("Password", result.getPassword());
			RequestDispatcher rd =request.getRequestDispatcher("DisplayInfo.jsp");
			rd.include(request, response);
			
		}
		else {
			out.println("Id does not matched ");
			RequestDispatcher rd =request.getRequestDispatcher("Dashboard.jsp");
			rd.include(request, response);
		}
		
		
		
		
	}

}
