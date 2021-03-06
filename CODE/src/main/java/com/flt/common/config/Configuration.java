package com.flt.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class Configuration extends PropertyPlaceholderConfigurer{
	
	public static Integer TMP_SESSION_USER_ID=1;
	
	private static Properties props=new Properties();
	
	static{
		Configuration d=new Configuration();
	}
	
	public Configuration() {
		// TODO Auto-generated constructor stub
		InputStream envIn=Configuration.class.getResourceAsStream("/env.properties");
		Properties envProp=new Properties();
		
		String env=null;
		try {
			envProp.load(envIn);
			env=envProp.getProperty("env");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		InputStream in=Configuration.class.getResourceAsStream("/"+env+".properties");
		try {
			Configuration.props.load(in);
			super.setProperties(props);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProp(String key){
		return Configuration.props.getProperty(key);
	}
	
	public static void main(String[] arg0){
		System.err.println(Configuration.getProp("testKey"));
	}
}
