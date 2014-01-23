package com.flt.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpringContextTest {

	private ApplicationContext context;
	
	@BeforeMethod
	public void initContext(){
		 context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void contextTest(){
		Assert.assertNotNull(context);
	}
}
