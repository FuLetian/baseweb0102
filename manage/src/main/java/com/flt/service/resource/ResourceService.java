package com.flt.service.resource;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ResourceMapper;
import com.flt.dao.model.Resource;
import com.flt.dao.model.ResourceExample;
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
	public Resource loadResourceByNum(Integer num,Integer userId) {
		// TODO Auto-generated method stub
		ResourceMapper m=getSqlSession().getMapper(ResourceMapper.class);
		ResourceExample ex=new  ResourceExample();
		ex.createCriteria().andNumEqualTo(num).andUserIdEqualTo(userId);
		
		List<Resource> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
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
		
		ResourceExample ex=new ResourceExample();
		
		ex.createCriteria().andUserIdEqualTo(resource.getUserId())
		.andNumEqualTo(resource.getNum());
		
		List<Resource> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			m.insert(resource);
		}else{
			Resource origin=list.get(0);
			
			origin.setText(resource.getText());
			m.updateByPrimaryKey(origin);
		}
	}

}
