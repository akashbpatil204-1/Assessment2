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
 * Servlet implementation class UpdateServlet1
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext factory =new ClassPathXmlApplicationContext("bean.xml");
		Employee obj =(Employee)factory.getBean("Employee");
		
	//	Object obj1 = ctx.getBean("Employee");
		String idd = request.getParameter("t0");
		System.out.println("updateServlet "+idd);
		obj.setId(Integer.parseInt(idd));
		System.out.println("Object:"+obj.getId());
		obj.setEname(request.getParameter("t1")); 
		obj.setRole(request.getParameter("t2"));
		String sal = request.getParameter("t3");
		
		obj.setSalary(Double.parseDouble(sal));
		obj.setUsername(request.getParameter("t4"));
		obj.setPassword(request.getParameter("t5"));
		 EmpDao in = new EmpDao();
		 in.delete(obj);
	     in.update(obj);
	     PrintWriter out = response.getWriter();
	     out.println("Data Updated");
	     RequestDispatcher rd =request.getRequestDispatcher("Dashboard.jsp");
		 rd.forward(request, response);
		
	}

}
