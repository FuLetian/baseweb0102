package com.flt.read.report;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flt.service.ball.report.FrequencyReport;

public class ReportCreator {

	private ApplicationContext context;
	
	@BeforeMethod
	public void initContext(){
		 context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void main(){
		FrequencyReport frequencyReport=context.getBean(FrequencyReport.class);
		
		frequencyReport.createExcel("E:/frequencyReport.xls");
	}
}
