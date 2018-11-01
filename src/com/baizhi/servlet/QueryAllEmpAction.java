package com.baizhi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.util.ApplicationContext;

public class QueryAllEmpAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String status=(String)session.getAttribute("status");
		if(status=="y"){
		ApplicationContext<EmployeeService> ac=new ApplicationContext<EmployeeService>();
		EmployeeService es=ac.getBean("EmployeeService");
		List<Employee> list=es.selectAllEmp();
		System.out.println(list);
	
		req.setAttribute("employees", list);
		req.getRequestDispatcher("/emplist.jsp").forward(req,resp);
		}else{
			resp.sendRedirect("/ems/login.jsp");
		}
	}

}
