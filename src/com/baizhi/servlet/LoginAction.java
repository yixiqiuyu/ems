package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceIm;
import com.baizhi.util.ApplicationContext;

public class LoginAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminname=req.getParameter("adminname");
		String password=req.getParameter("password");
		
		ApplicationContext<AdminService> ac=new ApplicationContext<AdminService>();
		AdminService as=ac.getBean("AdminService");
		Admin admin=new Admin();
		admin.setAdminname(adminname);
		admin.setPassword(password);
		HttpSession session=req.getSession();
		
		if(as.login(admin)){
				session.setAttribute("status", "y");
				session.setAttribute("admin",admin );
				resp.sendRedirect("/ems/queryallemployees");
		}else{
			resp.sendRedirect("/ems/login.jsp");
		}
		
	}

}
