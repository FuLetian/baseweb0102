package com.flt.service.ball.report.dto;


public class SortableDTO implements Comparable<SortableDTO>{

	private int num;
	private int count;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(SortableDTO o) {
		// TODO Auto-generated method stub
		return this.count-o.getCount();
	}
	
	
}
