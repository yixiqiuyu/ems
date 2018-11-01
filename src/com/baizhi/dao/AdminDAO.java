package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Admin;

public interface AdminDAO {
	public void insertAdmin(Admin admin);
	public Admin selectAdminByName(String adminname);
	public Admin queryByNameAndPassword(Admin admin);
	public void deleteAdmin(int id);
	public Admin updateAdmin(Admin admin);
	public List<Admin> queryAllAdmin();

}
