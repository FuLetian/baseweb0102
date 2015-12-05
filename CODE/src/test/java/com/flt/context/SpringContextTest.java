package com.flt.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextTest {

	private ApplicationContext context;
	
	//@BeforeMethod
	public void initContext(){
		 context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	//@Test
	public void contextTest(){
//		IOrderCommonService s=context.getBean(IOrderCommonService.class);
//		
//		//chart 1
//		List<Integer> days=new ArrayList<>();//最近一月号数集合
//		List<Integer> saleCount=null;//销量list
//		
//		Calendar today=Calendar.getInstance();
//		Calendar lastMonthDay=Calendar.getInstance();
//		
//		int lastMonth=today.get(Calendar.MONTH)-1;
//		lastMonthDay.set(Calendar.MONTH,lastMonth);
//		
//		int lastMonthMaxDay=lastMonthDay.getMaximum(Calendar.DAY_OF_MONTH);
//		for(int i=lastMonthDay.get(Calendar.DAY_OF_MONTH);i<=lastMonthMaxDay;i++){
//			days.add(i);
//		}
//		
//		int thisMonthThisDay=today.get(Calendar.DAY_OF_MONTH);
//		for(int i=1;i<=thisMonthThisDay;i++){
//			days.add(i);
//		}
//		
//		saleCount=s.listCountBetweenDateByRunstatus(lastMonthDay,today, Arrays.asList(0), 1);
//		
//		System.err.println(JSONArray.fromObject(days).toString());
//		System.err.println(JSONArray.fromObject(saleCount).toString());
	}
}
