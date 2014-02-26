package com.flt.common.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAutherticator extends Authenticator {

	private String username;
	private String password;
	
	public EmailAutherticator() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public EmailAutherticator(String username,String password) {
		// TODO Auto-generated constructor stub
		super();
		this.username=username;
		this.password=password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
