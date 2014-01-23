package com.flt.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flt.dao.model.Ball;
import com.flt.service.ball.BallService;

public class ReadTextToDB {
	private ApplicationContext context;
	
	private static int count=0;
	
	private SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeMethod
	public void initContext(){
		 context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void main(){
		File file=new File("E:/workspace/selenium/result/d");
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line=null;
			while((line=reader.readLine())!=null){
				writeLine(line);
			}
			reader.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void writeLine(String line) {
		// TODO Auto-generated method stub
		String[] eles=line.split(",");
		
		Integer term=Integer.valueOf(eles[0]);
		Date makeDate=null;
		String day=eles[2];
		Integer[] nums=coverNums(eles[3]);
		try {
			makeDate=fmt.parse(eles[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ball ball=new Ball();
		ball.setTerm(term);
		ball.setMakeDateTime(makeDate);
		ball.setRedOne(nums[0]);
		ball.setRedTwo(nums[1]);
		ball.setRedThree(nums[2]);
		ball.setRedFour(nums[3]);
		ball.setRedFive(nums[4]);
		ball.setRedSix(nums[5]);
		ball.setBlue(nums[6]);
		
		BallService service=this.context.getBean(BallService.class);
		service.addRecord(ball);
	}

	private Integer[] coverNums(String numsStr) {
		// TODO Auto-generated method stub
		String[] redBlue=numsStr.split("\\+");
		String[] reds=redBlue[0].split(" ");
		
		Integer[] balls=new Integer[7];
		
		balls[0]=Integer.valueOf(reds[0]);
		balls[1]=Integer.valueOf(reds[1]);
		balls[2]=Integer.valueOf(reds[2]);
		balls[3]=Integer.valueOf(reds[3]);
		balls[4]=Integer.valueOf(reds[4]);
		balls[5]=Integer.valueOf(reds[5]);
		balls[6]=Integer.valueOf(redBlue[1]);
		return balls;
	}
	
}
