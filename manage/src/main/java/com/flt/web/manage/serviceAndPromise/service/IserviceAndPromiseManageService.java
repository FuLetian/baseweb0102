package com.flt.web.manage.serviceAndPromise.service;

import com.flt.dao.model.Resource;

public interface IserviceAndPromiseManageService {

	Resource loadResourceByNum(Integer num,Integer userId);
	
	void saveOrUpdateResource(Resource resource);
}
