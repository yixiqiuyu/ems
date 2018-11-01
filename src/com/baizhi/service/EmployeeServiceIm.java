package com.baizhi.service;

import java.util.ArrayList;
import java.util.List;

import com.baizhi.dao.EmployeeDAO;
import com.baizhi.entity.Employee;
import com.baizhi.util.ApplicationContext;
import com.baizhi.util.TransactionManager;

public class EmployeeServiceIm implements EmployeeService{

	@Override
	public boolean addEmp(Employee employee) {
		// TODO Auto-generated method stub
		boolean b=false;
		ApplicationContext<EmployeeDAO> ac=new ApplicationContext<EmployeeDAO>();
		EmployeeDAO ed = ac.getBean("EmployeeDAO");
		Employee emp=ed.insertEmployee(employee);
		if(emp.getName()!=null){
			b=true;
			TransactionManager.commit();
		}else{
			b=false;
			TransactionManager.rollback();
		}	
		return b;
	}

	@Override
	public boolean deleteEmp(int id) {
		boolean b=false;
		ApplicationContext<EmployeeDAO> ac=new ApplicationContext<EmployeeDAO>();
		EmployeeDAO ed = ac.getBean("EmployeeDAO");
		try{
			ed.deleteEmployee(id);
			TransactionManager.commit();
			b=true;
		}catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
		
	}

	@Override
	public boolean updateEmp(Employee employee) {
		boolean b=false;
		ApplicationContext<EmployeeDAO> ac=new ApplicationContext<EmployeeDAO>();
		EmployeeDAO ed = ac.getBean("EmployeeDAO");
		try{
			TransactionManager.begin();
			ed.updateEmployee(employee);
			TransactionManager.commit();
			b=true;
		}catch(Exception e){
			e.printStackTrace();
			TransactionManager.rollback();
			b=false;
		}
		return b;
	}

	@Override
	public List<Employee> selectAllEmp() {
		ApplicationContext<EmployeeDAO> ac=new ApplicationContext<EmployeeDAO>();
		EmployeeDAO ed = ac.getBean("EmployeeDAO");
		List<Employee> list=new ArrayList<Employee>();
		try{
			list=ed.selectAllEmployees();
			TransactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee queryById(int id) {
		ApplicationContext<EmployeeDAO> ac=new ApplicationContext<EmployeeDAO>();
		EmployeeDAO ed = ac.getBean("EmployeeDAO");
		Employee emp=new Employee();
		try{
			TransactionManager.begin();
			emp=ed.queryById(id);
			TransactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			TransactionManager.rollback();
		}
		return emp;
	}

}
