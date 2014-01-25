package com.flt.web.itf.service;

import java.util.List;

import com.flt.dao.model.Comment;
import com.flt.web.itf.dto.ConsumerCommentDTO;

/**
 *<p>功能:</p>
 *<p></p>
 *<p>Copyright:Copyright(c)2013</p>
 *<p>Company:sky</p>
 *@author 付乐天
 *@version 1.0 */

public interface ICommentITFService {

	List<Comment> listCommentsByArticleId(Integer articleId,Integer userId);
	
	List<ConsumerCommentDTO> listConsumerCommentsByArticleId(Integer articleId,Integer userId);
}
