package com.flt.dao.client;

import java.util.List;

import com.flt.dao.model.Comment;

public interface CommentCustomMapper {

	List<Comment> findMaxCountLimitComment(Integer max);
}
