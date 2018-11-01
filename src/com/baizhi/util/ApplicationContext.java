package com.baizhi.util;

import java.io.InputStream;
import java.util.Properties;
public class ApplicationContext<T> {
	private static Properties p = new Properties();
	static{
		InputStream is = ApplicationContext.class.getResourceAsStream("/com/baizhi/conf/applicationContext.properties");
		try{                                                          
			p.load(is);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public T getBean(String key){
		try{
		Class c = Class.forName(p.getProperty(key));
		return (T)c.newInstance();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
