package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Employee;

public interface EmployeeDAO {
	public Employee insertEmployee(Employee employee);
	public void deleteEmployee(int id);
	public void updateEmployee(Employee employee);
	public List<Employee> selectAllEmployees();
	public Employee queryById(int id);
}
