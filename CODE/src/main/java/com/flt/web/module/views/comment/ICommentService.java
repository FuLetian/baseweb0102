package com.flt.web.module.views.comment;

import java.util.List;

import com.flt.dao.model.Comment;

public interface ICommentService {

	List<Comment> listHomePageComments(Integer max);
}
