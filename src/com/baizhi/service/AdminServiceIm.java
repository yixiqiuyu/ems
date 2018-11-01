package com.baizhi.service;

import java.sql.Connection;
import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.AdminDAOIm;
import com.baizhi.entity.Admin;
import com.baizhi.util.ApplicationContext;
import com.baizhi.util.JDBCUtil;
import com.baizhi.util.TransactionManager;

public class AdminServiceIm implements AdminService{

	@Override
	public boolean regist(Admin admin){
		boolean b=false;
			TransactionManager.begin();
			ApplicationContext<AdminDAO> ac = new ApplicationContext<AdminDAO>();
			AdminDAO ad = ac.getBean("AdminDAO");
			Admin admin2 = ad.selectAdminByName(admin.getAdminname());
			if(admin2.getAdminname()==null){
				ad.insertAdmin(admin);
				TransactionManager.commit();
				b = true;
			}else{
				TransactionManager.rollback();
				b=false;
			}
		return b;
	}

	@Override
	public boolean login(Admin admin) {
		boolean b=false;
		ApplicationContext<AdminDAO> ac = new ApplicationContext<AdminDAO>();
		AdminDAO ad = ac.getBean("AdminDAO");
		
			TransactionManager.begin();
			Admin admin2 = ad.queryByNameAndPassword(admin);
			TransactionManager.commit();
			if(admin2.getAdminname()!=null){
				b=true;
			}else{
				System.out.println("用户不存在");
				b=false;
			}
		return b;
	}
	
}
