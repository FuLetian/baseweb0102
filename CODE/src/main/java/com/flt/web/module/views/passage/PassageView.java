package com.flt.web.module.views.passage;

import java.util.List;

import org.springframework.ui.Model;

import com.flt.dao.model.Passage;
import com.flt.web.base.BaseView;

public class PassageView extends BaseView {
	
	private List<Passage> passages;

	public PassageView(Model model) {
		super(model, PassageView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub

	}

	public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}

}
