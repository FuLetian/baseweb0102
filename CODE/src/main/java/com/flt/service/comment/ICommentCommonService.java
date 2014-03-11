package com.flt.service.comment;

import java.util.List;

import com.flt.dao.model.Comment;
import com.flt.web.itf.dto.ConsumerCommentDTO;

public interface ICommentCommonService {

	List<ConsumerCommentDTO> listConsumerCommentsByArticleId(Integer articleId,Integer userId);
	
	Comment loadCommentById(Integer id);
	
	Comment loadCommnetByConsuerIdArticleId(Integer consumerId,Integer articleId);
	
	void saveComment(Comment comment);
	
	void updateComment(Comment comment);
	
	List<ConsumerCommentDTO> listConsumerCommentDTOsByUserId(Integer userId);
}
