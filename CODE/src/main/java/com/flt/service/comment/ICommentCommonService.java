package com.flt.service.comment;

import java.util.List;

import com.flt.web.itf.dto.ConsumerCommentDTO;

public interface ICommentCommonService {

	List<ConsumerCommentDTO> listConsumerCommentsByArticleId(Integer articleId,Integer userId);
}
