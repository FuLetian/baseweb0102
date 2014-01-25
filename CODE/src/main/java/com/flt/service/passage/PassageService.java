package com.flt.service.passage;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PassageMapper;
import com.flt.dao.model.Passage;
import com.flt.dao.model.PassageExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.passage.IPassageService;

@Service
public class PassageService extends BaseService implements IPassageService {

	@Override
	public Passage findPassageByNum(Integer num, Integer userId) {
		// TODO Auto-generated method stub
		
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		PassageExample ex=new PassageExample();
		ex.createCriteria().andNumEqualTo(num).andUserIdEqualTo(userId);
		List<Passage> list= m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

}
