package com.flt.web.context.dynamic;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.flt.common.config.Configuration;

public class DynamicURLFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		String requestURI=req.getRequestURI();
		
		boolean isHtmlRequest=isHtmlRequest(requestURI);
		if(Boolean.valueOf(Configuration.getProp("mode.develop"))&&isHtmlRequest){
			String dynamicURI=this.parseToMappingURLFromHtmlRequestURI(req);
			response.getWriter().write("<script>window.top.location.href='"+Configuration.getProp("db.server.domain")+dynamicURI+"'</script>");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

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
		for(int i=1;i<length-1;i++){
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
