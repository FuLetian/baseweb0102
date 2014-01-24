package com.flt.service.comment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.model.Comment;
import com.flt.web.module.views.comment.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Override
	public List<Comment> listHomePageComments(Integer max) {
		// TODO Auto-generated method stub
		return null;
	}

}
