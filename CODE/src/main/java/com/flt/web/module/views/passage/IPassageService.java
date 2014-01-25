package com.flt.web.module.views.passage;

import com.flt.dao.model.Passage;

public interface IPassageService {

	Passage findPassageByNum(Integer num,Integer userId);
}
