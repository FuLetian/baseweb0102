package com.flt.web.manage.passage.service;

import com.flt.dao.model.Passage;

public interface IPassageManageService {

	void saveOrUpdatePassage(Integer passageNum,String text,Integer userId);
	
	Passage loadPassageByNum(Integer passageNum,Integer uerId);
}
