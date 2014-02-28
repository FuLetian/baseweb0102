package com.flt.service.consumer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ConsumerMapper;
import com.flt.dao.model.Consumer;
import com.flt.dao.model.ConsumerExample;
import com.flt.service.base.BaseService;
import com.flt.web.itf.service.IConsumerITFService;

@Service
public class ConsumerService extends BaseService implements IConsumerITFService,IConsumerCommonService {

	@Override
	public Consumer login(String account, String password) {
		// TODO Auto-generated method stub
		ConsumerMapper m=this.getSqlSession().getMapper(ConsumerMapper.class);
		ConsumerExample ex=new ConsumerExample();
		ex.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
		
		List<Consumer> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public Consumer register(Integer userId,String realName, String pwd, String phoneNum,
			String address, String email, String thumbnailPath) {
		// TODO Auto-generated method stub
		ConsumerMapper m=this.getSqlSession().getMapper(ConsumerMapper.class);
		
		Consumer o=new Consumer();
		o.setAccount(realName);
		o.setAddress(address);
		o.setEmail(email);
		o.setPassword(pwd);
		o.setPhoneNum(phoneNum);
		o.setThumbnailPath(thumbnailPath);
		o.setUserId(userId);
		m.insert(o);
		
		return o;
	}

	@Override
	public Consumer loadConsumerById(Integer id) {
		// TODO Auto-generated method stub
		ConsumerMapper m=this.getSqlSession().getMapper(ConsumerMapper.class);
		return m.selectByPrimaryKey(id);
	}

}
