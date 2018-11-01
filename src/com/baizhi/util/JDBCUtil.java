package com.baizhi.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {
	private static Properties p = new Properties();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static InputStream is = JDBCUtil.class.getResourceAsStream("/com/baizhi/conf/dbcp.properties");
	static{
		try{
			p.load(is);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Connection getConnection()throws Exception{
		Connection conn = tl.get();
		if(conn==null){
			/*Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
			tl.set(conn);*/
			//获取数据源
			DataSource ds=BasicDataSourceFactory.createDataSource(p);
			//获取连接
			conn=ds.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement p){
		if(p!=null){try{p.close();}catch(Exception e){e.printStackTrace();}}
		if(conn!=null){try{conn.close();tl.remove();}catch(Exception e){e.printStackTrace();}}
	}
	
	public static void close(Connection conn,PreparedStatement p,ResultSet rs){
		if(rs!=null){try{rs.close();}catch(Exception e){e.printStackTrace();}}
		if(p!=null){try{p.close();}catch(Exception e){e.printStackTrace();}}
		if(conn!=null){try{conn.close();tl.remove();}catch(Exception e){e.printStackTrace();}}
	}
	
	public static java.sql.Date dealDate(String date)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//   String  --   java.util.Date
		java.util.Date utilDate = sdf.parse(date);
		//  java.util.Date   --   java.sql.Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
}
