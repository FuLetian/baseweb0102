package com.flt.common.utils;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.flt.common.config.Configuration;

public class EmailUtil {
	
	private static String HOST=Configuration.getProp("mail.smtp.host");
	private static String PORT=Configuration.getProp("mail.smtp.port");
	private static String AUTH=Configuration.getProp("mail.smtp.auth");
	private static String USERNAME=Configuration.getProp("mail.username");
	private static String PASSWORD=Configuration.getProp("mail.password");
	private static String FROM=Configuration.getProp("mail.from");

	public static boolean send(String subject,String body,String toEmail){
		
		Properties props=new Properties();
		props.put("mail.smtp.host", EmailUtil.HOST);
		props.put("mail.smtp.port", EmailUtil.PORT);
		props.put("mail.smtp.auth", EmailUtil.AUTH);
		props.put("mail.smtp.timeout", 25000);
		props.put("mail.smtp.socketFactory.port", 465);
		props.put("mail.smtp.socketFactory.fallback", false);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		JavaMailSenderImpl sender=new JavaMailSenderImpl();
		sender.setHost(HOST);
		sender.setUsername(USERNAME);
		sender.setPassword(PASSWORD);
		sender.setJavaMailProperties(props);
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setFrom(FROM);
		mail.setTo(toEmail);
		mail.setSubject(subject);
		mail.setText(body);
		
		sender.send(mail);
		
		return true;
	}
	
	public static void main(String[] d){
		EmailUtil.send("sub", "body", "313376212@qq.com");
	}
}
