package com.baizhi.util;

import java.sql.ResultSet;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Employee;

public class EmployeeRowmapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs) {
		Employee emp=new Employee();
		try{
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emp.setAge(rs.getInt(4));
			emp.setBirthday(rs.getDate(5).toString());
			emp.setSex(rs.getString(6));
			emp.setScore(rs.getDouble(7));
		}catch(Exception e){
			e.printStackTrace();
		}
		return emp;
	}

	

}
