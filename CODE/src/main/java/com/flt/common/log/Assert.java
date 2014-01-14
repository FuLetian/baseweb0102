package com.flt.common.log;

import org.apache.logging.log4j.LogManager;

public class Assert {
	
	public static LogEnum notNull(Object obj,String msg,Class<?> clz){
		if(obj==null){
			LogManager.getLogger(clz).error(msg);
			
			return LogEnum.SUCCESS;
		}
		
		return LogEnum.FAIL;
	}
	
}
