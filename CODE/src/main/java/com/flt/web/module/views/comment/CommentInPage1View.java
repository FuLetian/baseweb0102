package com.flt.web.module.views.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flt.common.annotation.View;
import com.flt.common.view.BaseView;

@View(template="component/comment/{theme}/commentInPage1View.ftl")
public class CommentInPage1View extends BaseView {
	
	private static Integer COMMENT_MAX_COUNT=5;
	
	@Autowired
	private ICommentService service;

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		
		List<CommentConsumerDTO> list=service.listHomePageComments(COMMENT_MAX_COUNT,userId);
		
		root.put("dtos", list);
	}
}
