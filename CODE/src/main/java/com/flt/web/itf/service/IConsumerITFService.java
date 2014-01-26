package com.flt.web.itf.service;

import com.flt.dao.model.Consumer;

public interface IConsumerITFService {

	Consumer login(String account,String password);

	Consumer register(Integer userId,String realName, String pwd1, String phoneNum,
			String address, String email, String thumbnailPath);
}
