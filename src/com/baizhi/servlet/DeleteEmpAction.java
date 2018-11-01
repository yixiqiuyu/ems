package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.service.EmployeeService;
import com.baizhi.util.ApplicationContext;

public class DeleteEmpAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id1=Integer.parseInt(req.getParameter("id"));
		System.out.println(id1);
		ApplicationContext<EmployeeService> ac=new ApplicationContext<EmployeeService>();
		EmployeeService es=ac.getBean("EmployeeService");
		es.deleteEmp(id1);
		resp.sendRedirect("/ems/queryallemployees");
	}
}
