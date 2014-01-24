package com.flt.web.manage.serviceAndPromise.service;

import com.flt.dao.model.Resource;

public interface IserviceAndPromiseManageService {

	Resource loadResourceById(Integer id);
	
	void saveOrUpdateResource(Resource resource);
}
