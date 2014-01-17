package com.flt.service.ball;

import org.springframework.stereotype.Service;

import com.flt.dao.client.BallMapper;
import com.flt.dao.model.Ball;
import com.flt.service.base.BaseService;

@Service
public class BallService extends BaseService {

	
	public void addRecord(Ball ball){
		this.getSqlSession().getMapper(BallMapper.class).insert(ball);
	}
}
