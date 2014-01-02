package com.flt.service.passage;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PassageMapper;
import com.flt.dao.model.Passage;
import com.flt.dao.model.PassageExample;
import com.flt.service.base.BaseService;
import com.flt.web.pages.controller.IPage1PassageService;

@Service
public class PassageServiceImpl extends BaseService implements IPage1PassageService {

	@Override
	public List<Passage> listPassageByType(int type) {
		// TODO Auto-generated method stub
		PassageMapper mapper=this.getSqlSession().getMapper(PassageMapper.class);
		
		PassageExample ex=new PassageExample();
		ex.createCriteria().andTypeEqualTo(type);
		
		return mapper.selectByExample(ex);
	}

}
