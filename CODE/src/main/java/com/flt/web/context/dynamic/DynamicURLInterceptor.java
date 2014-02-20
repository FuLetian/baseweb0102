package com.flt.web.context.dynamic;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flt.common.config.Configuration;

public class DynamicURLInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		String requestURI=request.getRequestURI();
		boolean isHtmlRequest=isHtmlRequest(requestURI);
		
		if(Boolean.valueOf(Configuration.getProp("mode.develop"))&&isHtmlRequest){
			String mappingURL=parseToMappingURLFromHtmlRequestURI(request);
			System.err.println(">>>>>>>>>>>"+mappingURL);
		}
		
		if(!isHtmlRequest){
			String b="http://localhost:8089/baseweb/page1/page2-articleId-2.html";
			//response.getWriter().write("<script>window.top.location.href='http://localhost:8089/baseweb/page1/view?channelId=1'</script>");
		}
		
		return super.preHandle(request, response, handler);
	}

	private boolean isHtmlRequest(String requestURI) {
		// TODO Auto-generated method stub
		return requestURI.endsWith(".html");
	}

	private String parseToMappingURLFromHtmlRequestURI(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String requestURI=request.getRequestURI();
		
		String contextPath=request.getContextPath();
		if(contextPath==null||contextPath.equals("")){
			contextPath="/";
		}
		
		String[] paths1=requestURI.split("/");
		String path1=paths1[paths1.length-1];
		path1=path1.substring(0, path1.length()-5);
		
		String[] paths2=path1.split("-");
		Map<String, String> paramTreeMap=new TreeMap<>();
		int length=paths2.length;
		for(int i=1;i<length;i++){
			paramTreeMap.put(paths2[i], paths2[i+1]);
		}
		
		StringBuffer dynamicRequestURL=new StringBuffer(paths2[0]+"/view?");
		Set<Entry<String, String>> entrySet=paramTreeMap.entrySet();
		Iterator<Entry<String,String>> it=entrySet.iterator();
		while(it.hasNext()){
			Entry<String, String> item=it.next();
			dynamicRequestURL.append(item.getKey()+"="+item.getValue()+"&");
		}
		
		
		return dynamicRequestURL.toString();
	}
}
