package com.flt.web.module.views.comment;

import java.util.List;

public interface ICommentService {

	List<CommentConsumerDTO> listHomePageComments(Integer max,Integer userId);
}
