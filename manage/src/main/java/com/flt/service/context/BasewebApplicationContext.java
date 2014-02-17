package com.flt.service.context;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.flt.common.freemarker.htmlAbled;
import com.flt.web.manage.homepage.service.IHomepageService;

@Service
public class BasewebApplicationContext implements ApplicationContextAware,IHomepageService {
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}

	@Override
	public void staticWeb(Integer userId) {
		// TODO Auto-generated method stub
		Map<String, htmlAbled> controllers= applicationContext.getBeansOfType(htmlAbled.class);
	}
	

}
