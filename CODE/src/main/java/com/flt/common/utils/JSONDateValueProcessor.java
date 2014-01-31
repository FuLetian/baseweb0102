package com.flt.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONDateValueProcessor implements JsonValueProcessor {
	
	private static SimpleDateFormat FMT=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		
		if(arg0 instanceof Date){
			return FMT.format(arg0);
		}
		
		return arg0;
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			return FMT.format(arg1);
		}
		
		return arg0;
	}
	

}
