package com.flt.service.consumer;

import com.flt.dao.model.Consumer;

public interface IConsumerCommonService {

	Consumer loadConsumerById(Integer id);
	
	int registConsumer(String account,String emailAddress,String pwd,String name,String thumbnailPath,String address,String phoneNum,Integer userId);
}
