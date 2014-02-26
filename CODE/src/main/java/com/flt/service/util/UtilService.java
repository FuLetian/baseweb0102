package com.flt.service.util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ConsumerMapper;
import com.flt.dao.client.UserMapper;
import com.flt.dao.model.Consumer;
import com.flt.dao.model.ConsumerExample;
import com.flt.dao.model.User;
import com.flt.service.base.BaseService;
import com.flt.web.common.service.ICommonService;

@Service
public class UtilService extends BaseService implements ICommonService {

	@Override
	public User loadUserById(Integer id) {
		// TODO Auto-generated method stub
		
		UserMapper m=this.getSqlSession().getMapper(UserMapper.class);
		
		
		return m.selectByPrimaryKey(id);
	}

	@Override
	public Consumer findConsumerByEmail(String email) {
		// TODO Auto-generated method stub
		ConsumerMapper m=this.getSqlSession().getMapper(ConsumerMapper.class);
		
		ConsumerExample e=new ConsumerExample();
		e.createCriteria().andEmailEqualTo(email);
		
		List<Consumer> list=m.selectByExample(e);
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
