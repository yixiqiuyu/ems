package com.baizhi.test;

import java.sql.Connection;

import org.junit.Test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.AdminDAOIm;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.service.EmployeeServiceIm;
import com.baizhi.util.JDBCUtil;

public class UtilTest {
	private Admin name;
	@Test
	public void test1() throws Exception{
		Connection conn=JDBCUtil.getConnection();
		System.out.println(conn);
	}
	@Test
	public void test2(){
		AdminDAO ad=new AdminDAOIm();
		Admin admin=new Admin();
		admin.setAdminname("葛建");
		admin.setPassword("123456");
		ad.insertAdmin(admin);
	}
	@Test
	public void test3(){
		AdminDAO ad=new AdminDAOIm();
		name = ad.selectAdminByName("gejian");
		System.out.println(name);
	}
	@Test
	public void test4(){
		//拿不到id
		AdminDAO ad=new AdminDAOIm();
		Admin admin=new Admin();
		admin.setAdminname("葛建");
		admin.setPassword("123456");
		 System.out.println(ad.queryByNameAndPassword(admin));
	}
	@Test
	public void test5(){
		AdminDAO ad=new AdminDAOIm();
		ad.deleteAdmin(2);
	}
	@Test
	public void test6(){
		AdminDAO ad=new AdminDAOIm();
		System.out.println(ad.queryAllAdmin());
	}
	@Test
	public void test7(){
		EmployeeService es=new EmployeeServiceIm();
		Employee e=new Employee();
		e.setId(22);
		e.setName("明天");
		e.setAge(18);
		e.setBirthday("1995-10-12");
		e.setSalary(500.2);
		e.setSex("m");
		e.setScore(65.5);
		es.updateEmp(e);
		
	}
}
