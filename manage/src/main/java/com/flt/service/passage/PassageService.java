package com.flt.service.passage;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PassageMapper;
import com.flt.dao.model.Passage;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.passage.IPassageService;

@Service
public class PassageService extends BaseService implements IPassageService {

	@Override
	public Passage findPassageById(Integer id) {
		// TODO Auto-generated method stub
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		return m.selectByPrimaryKey(id);
	}

}
