package com.flt.web.manage.config.dto;

public class LeftMenu {

	private String name;
	private String location;
	private boolean isDividingLine=false;
	
	public LeftMenu(String name,String location,boolean isDividingLine) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.location=location;
		this.isDividingLine=isDividingLine;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isDividingLine() {
		return isDividingLine;
	}
	public void setDividingLine(boolean isDividingLine) {
		this.isDividingLine = isDividingLine;
	}
	
	
}
