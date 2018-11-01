package com.baizhi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.util.JDBCUtil;

public class JDBCTemplate<T> {
     //��ɾ��
	public void executeUpdate(String sql,Object... orgs){
		Connection conn = null;
		PreparedStatement p = null;
		
		try{
			conn = JDBCUtil.getConnection();
			p = conn.prepareStatement(sql);
			
			if(hasUpdateParams(orgs)){
				for(int i=0;i<orgs.length;i++){
					p.setObject(i+1, orgs[i]);
				}
			}
			p.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, p);
		}
	}

	private boolean hasUpdateParams(Object[] orgs) {
		return orgs.length>0;
	}
	//���в�ѯ
	public Object executeQueryOne(String sql,RowMapper<T> rm,Object...args){
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet rs= null;
		T o = null;
		try{
			conn = JDBCUtil.getConnection();
			p=conn.prepareStatement(sql);
			if(hasUpdateParams(args)){
				for(int i=0;i<args.length;i++){
					p.setObject(i+1, args[i]);
				}
			}
			rs = p.executeQuery();
			if(rs.next()){
				o = rm.mapRow(rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, p,rs);
		}
		return o;
	}
	//���в�ѯ
	public List<T> executeQueryList(String sql,RowMapper<T> rm,Object...args){
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet rs= null;
		List<T> list = new ArrayList<T>();
		try{
			conn = JDBCUtil.getConnection();
			p=conn.prepareStatement(sql);
			if(hasUpdateParams(args)){
				for(int i=0;i<args.length;i++){
					p.setObject(i+1, args[i]);
				}
			}
			rs = p.executeQuery();
			while(rs.next()){
				T t = rm.mapRow(rs);
				list.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, p,rs);
		}
		return list;
	}
}
