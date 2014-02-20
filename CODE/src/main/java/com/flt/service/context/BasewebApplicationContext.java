package com.flt.service.context;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.flt.common.freemarker.HTMLAbled;
import com.flt.common.utils.CopyDirectoryUtil;
import com.flt.web.common.service.ICommonStaticWebService;

@Service
public class BasewebApplicationContext implements ApplicationContextAware,ICommonStaticWebService {
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}

	@Override
	public void staticweb(Integer userId,HttpServletRequest req) {
		// TODO Auto-generated method stub
		Map<String, HTMLAbled> controllerMap= applicationContext.getBeansOfType(HTMLAbled.class);
		
		Set<Entry<String, HTMLAbled>> list=controllerMap.entrySet();
		Iterator<Entry<String, HTMLAbled>> it=list.iterator();
		while(it.hasNext()){
			Entry<String, HTMLAbled> e=it.next();
			e.getValue().createHtml(req, userId);
		}
		
		String filesContainer=req.getSession().getServletContext().getRealPath("h");
		System.err.println(filesContainer);
		//CopyDirectoryUtil.entry(filesContainer, "E:\\htmlApp");
	}
	

}
