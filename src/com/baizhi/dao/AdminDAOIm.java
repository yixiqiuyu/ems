package com.baizhi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.util.AdminRowmapper;
import com.baizhi.util.JDBCTemplate;
import com.baizhi.util.JDBCUtil;

public class AdminDAOIm implements AdminDAO{
	Admin admin=new Admin();
	JDBCTemplate<Admin> jt = new JDBCTemplate<Admin>();
	@Override
	public void insertAdmin(Admin admin) {
//		Connection conn=null;
//		PreparedStatement p=null;
//		try{
//			conn=JDBCUtil.getConnection();
//			String sql="insert into admin(id,adminname,password) values(admin_seq.nextval,?,?)";
//			p=conn.prepareStatement(sql);
//			p.setString(1, admin.getAdminname());
//			p.setString(2, admin.getPassword());
//			p.executeUpdate();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.close(null, p);
//		}
		String sql="insert into admin(id,adminname,password) values(admin_seq.nextval,?,?)";
		jt.executeUpdate(sql,admin.getAdminname(),admin.getPassword());
		/*JDBCTemplate jt=new JDBCTemplate<Admin>();
		jt.update("insert into admin(id,adminname,password) values(admin_seq.nextval,?,?)");
		*/
	}

	@Override
	public Admin selectAdminByName(String adminname) {
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtil.getConnection();
			String sql = "select * from admin where adminname=?";
			p=conn.prepareStatement(sql);
			p.setString(1, adminname);
			rs = p.executeQuery();
			while(rs.next()){
				admin.setId(rs.getInt(1));
				admin.setAdminname(rs.getString(2));
				admin.setPassword(rs.getString(3));
			}
		}catch(Exception e){e.printStackTrace();}finally{
			JDBCUtil.close(null, p,rs);
		}
		return admin;
	}

	@Override
	public Admin queryByNameAndPassword(Admin admin) {
//		Connection conn = null;
//		PreparedStatement p = null;
//		ResultSet rs = null;
//		try{
//			conn = JDBCUtil.getConnection();
//			String sql = "select * from admin where adminname=? and password=?";
//			p=conn.prepareStatement(sql);
//			p.setString(1, admin.getAdminname());
//			p.setString(2, admin.getPassword());
//			rs = p.executeQuery();
//			while(rs.next()){
//				admin.setId(rs.getInt(1));
//				admin.setAdminname(rs.getString(2));
//				admin.setPassword(rs.getString(3));
//			}
//		}catch(Exception e){e.printStackTrace();}finally{
//			JDBCUtil.close(null, p,rs);
//		}
//		return admin;
		String sql = "select * from admin where adminname=? and password=?";
		Object object = jt.executeQueryOne(sql,new AdminRowmapper(),admin.getAdminname(),admin.getPassword());
		return (Admin)object;
		
	}

	@Override
	public void deleteAdmin(int id) {
		Connection conn=null;
		PreparedStatement p=null;
		try {
			conn=JDBCUtil.getConnection();
			String sql="delete from admin where id=?";
			p=conn.prepareStatement(sql);
			p.setInt(1,id);
			p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, p);
		}
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Connection conn=null;
		PreparedStatement p=null;
		try {
			conn=JDBCUtil.getConnection();
			String sql="update admin set adminname=?,password=? where id=?";
			p=conn.prepareStatement(sql);
			p.setString(1, admin.getAdminname());
			p.setString(2, admin.getPassword());
			p.setInt(3, admin.getId());
			p.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null,p);
		}
		return admin;
	}

	@Override
	public List<Admin> queryAllAdmin() {
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet rs = null;
		List<Admin> admins = new ArrayList<Admin>();
		try{
			//1.获取数据库连接
			conn = JDBCUtil.getConnection();
			//2.构建执行sql的工具
			String sql = "select * from admin";
			p=conn.prepareStatement(sql);
			//3.动态参数赋值     全查操作不需要
			//4.执行sql
			rs = p.executeQuery();
			//5.结果集的处理
			while(rs.next()){
				Admin admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setAdminname(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admins.add(admin);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, p,rs);
		}
		return admins;
	}

}
