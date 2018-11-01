package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.AdminDAOIm;
import com.baizhi.dao.EmployeeDAO;
import com.baizhi.dao.EmployeeDAOIm;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Employee;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceIm;

public class TestDAO {
@Test
public void insert(){
	AdminDAO ad = new AdminDAOIm();
	ad.insertAdmin(new Admin("zhangsan","1111"));
}
@Test
public void login(){
	AdminDAO ad = new AdminDAOIm();
	Admin admin = ad.queryByNameAndPassword(new Admin("zhangsan","1111"));
	System.out.println(admin.toString());
}
@Test
public void regist(){
	AdminService ad = new AdminServiceIm();
	 boolean regist = ad.regist(new Admin("zhang","1112231"));
	System.out.println(regist);
}
@Test
public void login2(){
	AdminService ad = new AdminServiceIm();
	 boolean login = ad.login(new Admin("zhangsan","1111"));
	System.out.println(login);
}
@Test
public void test7(){
	EmployeeDAO ed=new EmployeeDAOIm();
	Employee e=new Employee();
	e.setId(1);
	e.setName("hehe");
	e.setAge(18);
	e.setBirthday("1995-10-12");
	e.setSalary(500.2);
	e.setSex("m");
	e.setScore(65.5);

		ed.insertEmployee(e);
}
@Test
public void test9(){
	EmployeeDAO ed=new EmployeeDAOIm();
	ed.deleteEmployee(3);
}
@Test
public void test10(){
	EmployeeDAO ed=new EmployeeDAOIm();
	Employee e=new Employee();
	e.setName("lalala");
	e.setAge(25);
	e.setBirthday("1998-12-12");
	e.setSalary(1500.2);
	e.setSex("f");
	e.setScore(85.5);
	ed.updateEmployee(e);
}
@Test
public void test11(){
	EmployeeDAO ed=new EmployeeDAOIm();
	List<Employee> e1 = ed.selectAllEmployees();
	for (Employee employee : e1) {
		System.out.println(employee);
	}
	
}
@Test
public void test12(){
	
}
}
