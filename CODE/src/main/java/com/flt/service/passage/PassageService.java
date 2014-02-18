package com.flt.service.passage;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PassageMapper;
import com.flt.dao.model.Passage;
import com.flt.dao.model.PassageExample;
import com.flt.service.base.BaseService;
import com.flt.web.manage.passage.service.IPassageManageService;
import com.flt.web.module.views.passage.IPassageService;

@Service
public class PassageService extends BaseService implements IPassageService,IPassageManageService {

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

	@Override
	public void saveOrUpdatePassage(Integer passageNum, String text,
			Integer userId) {
		// TODO Auto-generated method stub
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		PassageExample ex=new  PassageExample();
		ex.createCriteria().andNumEqualTo(passageNum).andUserIdEqualTo(userId);
		
		List<Passage> list=m.selectByExample(ex);
		
		Passage origin=null;
		if(list.isEmpty()){
			origin=new Passage();
			origin.setcDt(new Date());
			origin.setNum(passageNum);
			origin.setIdx(0);
			origin.setText(text);
			origin.setType(1);
			origin.setuDt(new Date());
			origin.setUserId(userId);
			m.insert(origin);
		}else{
			origin=list.get(0);
			origin.setText(text);
			origin.setuDt(new Date());
			origin.setUserId(userId);
			origin.setNum(passageNum);
			m.updateByPrimaryKey(origin);
		}
	}

	@Override
	public Passage loadPassageByNum(Integer passageNum, Integer userId) {
		// TODO Auto-generated method stub
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		PassageExample ex=new  PassageExample();
		ex.createCriteria().andNumEqualTo(passageNum).andUserIdEqualTo(userId);
		
		List<Passage> list=m.selectByExample(ex);
		
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

}
