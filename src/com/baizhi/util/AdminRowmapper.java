package com.baizhi.util;

import java.sql.ResultSet;

import com.baizhi.entity.Admin;

//��  rs  ת��Ϊ��֪  ��   userʵ��
public class AdminRowmapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs) {
		Admin admin = new Admin();
		try{
			admin.setId(rs.getInt(1));
			admin.setAdminname(rs.getString(2));
			admin.setPassword(rs.getString(3));
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

}
