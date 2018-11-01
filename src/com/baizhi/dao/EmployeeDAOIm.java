package com.baizhi.dao;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.entity.Employee;
import com.baizhi.util.EmployeeRowmapper;
import com.baizhi.util.JDBCTemplate;
import com.baizhi.util.JDBCUtil;


public class EmployeeDAOIm implements EmployeeDAO {
	JDBCTemplate<Employee> jt=new JDBCTemplate<Employee>();
	@Override
	public Employee insertEmployee(Employee employee){
		// TODO Auto-generated method stub
		String sql="insert into t_employee(id,name,salary,age,birthday,sex,score) values(emp_seq.nextval,?,?,?,?,?,?)";
		try {
			jt.executeUpdate(sql, employee.getName(),employee.getSalary(),employee.getAge(),JDBCUtil.dealDate(employee.getBirthday()),employee.getSex(),employee.getScore());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_employee where id=?";
		jt.executeUpdate(sql, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql="update t_employee set name=?,salary=?,age=?,birthday=?,sex=?,score=? where id=?";
		try {
			jt.executeUpdate(sql, employee.getName(),employee.getSalary(),employee.getAge(),JDBCUtil.dealDate(employee.getBirthday()),employee.getSex(),employee.getScore(),employee.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=new ArrayList<Employee>();
		String sql="select * from t_employee";
		List<Employee> e = jt.executeQueryList(sql, new EmployeeRowmapper());
		return e;
	}

	@Override
	public Employee queryById(int id) {
		String sql="select * from t_employee where id=?";
		Employee e = (Employee) jt.executeQueryOne(sql, new EmployeeRowmapper(), id);
		return e;
	}

}
