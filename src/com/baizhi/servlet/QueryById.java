package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.util.ApplicationContext;

public class QueryById extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		ApplicationContext<EmployeeService> ec=new ApplicationContext<EmployeeService>();
		EmployeeService es = ec.getBean("EmployeeService");
		Employee emp = es.queryById(id);
		
		req.setAttribute("emp", emp);
		req.getRequestDispatcher("/updateEmp.jsp").forward(req,resp);
	}

}
