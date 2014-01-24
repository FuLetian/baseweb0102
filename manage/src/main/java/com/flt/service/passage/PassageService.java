package com.flt.service.passage;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.flt.dao.client.PassageMapper;
import com.flt.dao.model.Passage;
import com.flt.service.base.BaseService;
import com.flt.web.manage.passage.service.IPassageManageService;
import com.flt.web.module.views.passage.IPassageService;

@Service
public class PassageService extends BaseService implements IPassageService ,IPassageManageService{

	@Override
	public Passage findPassageById(Integer id) {
		// TODO Auto-generated method stub
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		return m.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdatePassage(Integer id, String text) {
		// TODO Auto-generated method stub
		PassageMapper m=this.getSqlSession().getMapper(PassageMapper.class);
		
		Passage origin=this.findPassageById(id);
		if(origin==null){
			origin=new Passage();
			origin.setcDt(new Date());
			origin.setId(id);
			origin.setIdx(0);
			origin.setText(text);
			origin.setType(1);
			origin.setuDt(new Date());
			m.insert(origin);
		}else{
			origin.setText(text);
			origin.setuDt(new Date());
			m.updateByPrimaryKey(origin);
		}
	}

	@Override
	public Passage loadPassageById(Integer id) {
		// TODO Auto-generated method stub
		return this.findPassageById(id);
	}

}
