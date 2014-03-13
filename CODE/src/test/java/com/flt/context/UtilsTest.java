package com.flt.context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class UtilsTest {

	//@Test
	public void sort(){
		
		Map<String, Object> map=new HashMap<>();
		
		map.put("zuletian", 333);
		map.put("buletian", 333);
		map.put("cianlefu", 34545);
		map.put("detianfu", 9297);
		
		Set<String> keys=map.keySet();
		
		Object[] as= keys.toArray();
		out(as);
		Arrays.sort(as);
		out(as);
	}
	
	private void out(Object[] as){
		for(Object s:as){
			System.err.println(s);
		}
		System.err.println("--------------------");
	}
}
