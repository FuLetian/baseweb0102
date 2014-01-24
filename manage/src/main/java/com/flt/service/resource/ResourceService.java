package com.flt.service.resource;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ResourceMapper;
import com.flt.dao.model.Resource;
import com.flt.service.base.BaseService;
import com.flt.web.manage.serviceAndPromise.service.IserviceAndPromiseManageService;
import com.flt.web.module.views.staticstate.IServiceAndPromiseService;

@Service
public class ResourceService extends BaseService implements IServiceAndPromiseService ,IserviceAndPromiseManageService{

	@Override
	public Resource findResourceById(Integer id) {
		// TODO Auto-generated method stub
		ResourceMapper m=getSqlSession().getMapper(ResourceMapper.class);
		
		return m.selectByPrimaryKey(id);
	}

	@Override
	public Resource loadResourceById(Integer id) {
		// TODO Auto-generated method stub
		return this.findResourceById(id);
	}

	@Override
	public void saveOrUpdateResource(Resource resource) {
		// TODO Auto-generated method stub
		ResourceMapper m=getSqlSession().getMapper(ResourceMapper.class);
		
		if(resource.getcDt()==null){
			resource.setcDt(new Date());
		}
		
		if(resource.getuDt()==null){
			resource.setuDt(new Date());
		}
		
		if(resource.getId()==null){
			m.insert(resource);
		}else{
			m.updateByPrimaryKey(resource);
		}
	}

}
