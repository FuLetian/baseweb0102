package com.flt.web.sample.views.model;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.flt.web.sample.views.MenuView;

public class Menu {
	
	private static Random random=new Random(Calendar.getInstance().getTimeInMillis());
	
	private int id;

	private List<Menu> list;
	
	private String title;
	
	public Menu() {
		// TODO Auto-generated constructor stub
		this.id=Menu.random.nextInt(100000000);
		
		MenuView.menuMap.put(String.valueOf(this.id), this);
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}
	
}
