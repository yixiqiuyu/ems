package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.util.ApplicationContext;

public class AddEmpAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String salary=req.getParameter("salary");
		String age=req.getParameter("age");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");
		String score=req.getParameter("score");
		HttpSession session=req.getSession();
		ApplicationContext<EmployeeService> ac=new ApplicationContext<EmployeeService>();
		EmployeeService es=ac.getBean("EmployeeService");
		Employee e=new Employee();
		e.setName(name);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		e.setBirthday(birthday);
		e.setSex(sex);
		e.setScore(Double.parseDouble(score));
		if(es.addEmp(e)){
			System.out.println(e.getSex());
			resp.sendRedirect("/ems/queryallemployees");
		}else{
			resp.sendRedirect("/ems/queryallemployees");
		}
		
	}

}
