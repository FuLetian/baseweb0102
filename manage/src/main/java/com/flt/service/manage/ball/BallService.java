package com.flt.service.manage.ball;

import org.springframework.stereotype.Service;

import com.flt.dao.client.BallMapper;
import com.flt.dao.model.Ball;
import com.flt.service.manage.base.BaseManageService;

@Service
public class BallService extends BaseManageService {

	
	public void addRecord(Ball ball){
		this.getSqlSession().getMapper(BallMapper.class).insert(ball);
	}
}
