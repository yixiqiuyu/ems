package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Employee;

public interface EmployeeService {
	public boolean addEmp(Employee employee);
	public boolean deleteEmp(int id);
	public boolean updateEmp(Employee employee);
	public List<Employee> selectAllEmp();
	public Employee queryById(int id);
}
