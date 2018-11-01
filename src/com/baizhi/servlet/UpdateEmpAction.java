package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.util.ApplicationContext;

public class UpdateEmpAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id1=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String salary=req.getParameter("salary");
		String age=req.getParameter("age");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");
		String score=req.getParameter("score");
		Employee e=new Employee();
		e.setId(id1);
		e.setName(name);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		e.setBirthday(birthday);
		e.setSex(sex);
		e.setScore(Double.parseDouble(score));
		System.out.println(e);
		ApplicationContext<EmployeeService> ac=new ApplicationContext<EmployeeService>();
		EmployeeService es=ac.getBean("EmployeeService");
		boolean emp = es.updateEmp(e);
		if(emp){
			System.out.println("成功修改");
			resp.sendRedirect("/ems/queryallemployees");
		}
	}

}
