package com.flt.read.report;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flt.service.ball.report.FrequencyReport;

public class ReportCreator {

	private ApplicationContext context;
	
	@BeforeMethod
	public void initContext(){
		// context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void main(){
		
		String str="E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\baseweb\\css\\common.css";
		
		int index=str.lastIndexOf(File.separator);
		
		String str2=str.substring(0,index);
		
		System.err.println(str2);
	}
}
