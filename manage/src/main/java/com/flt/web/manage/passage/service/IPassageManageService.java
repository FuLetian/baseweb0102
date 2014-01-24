package com.flt.web.manage.passage.service;

import com.flt.dao.model.Passage;

public interface IPassageManageService {

	void saveOrUpdatePassage(Integer id,String text);
	
	Passage loadPassageById(Integer id);
}
