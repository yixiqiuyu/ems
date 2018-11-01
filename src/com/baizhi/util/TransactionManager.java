package com.baizhi.util;

import java.sql.Connection;

public class TransactionManager {
	/*
	        事务管理器
	        用于管理事务
	 */
	
	// 开启事务
	public static void begin(){
		try{
			Connection conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//事务提交
	public static void commit(){
		Connection conn = null;
		try{
			conn = JDBCUtil.getConnection();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, null);
		}
	}
	
	//事务回滚
	public static void rollback(){
		Connection conn = null;
		try{
			conn=JDBCUtil.getConnection();
			conn.rollback();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, null);
		}
	}
	
}
