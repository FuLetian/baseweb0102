package com.flt.service.manage.base;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseManageService extends SqlSessionDaoSupport{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
	public void setSqlSessionFactory(){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
