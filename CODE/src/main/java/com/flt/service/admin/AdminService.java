package com.flt.service.admin;

import org.springframework.stereotype.Service;

import com.flt.dao.client.AdminMapper;
import com.flt.dao.model.AdminExample;
import com.flt.service.base.BaseService;

/**
 * 主要限于[admin]的操作
 * @author Administrator
 *
 */
@Service
public class AdminService extends BaseService{
	
	public int countAdmin(){
		AdminMapper mapper=getSqlSession().getMapper(AdminMapper.class);
		
		AdminExample example=new AdminExample();
		example.createCriteria().andAccountIdEqualTo("abc");
		
		int count=mapper.countByExample(example);
		
		return count;
	}
}
