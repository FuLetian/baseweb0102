package com.flt.web.pages.controller;

import java.util.List;

import com.flt.dao.model.Passage;

public interface IPage1PassageService {

	List<Passage> listPassageByType(int type);
}
