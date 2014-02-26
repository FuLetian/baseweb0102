package com.flt.service.comment;

import java.util.List;

import com.flt.dao.model.Comment;

public interface ICommentCommonService {

	List<Comment> listCommentsByArticleId(Integer articleId);
}
