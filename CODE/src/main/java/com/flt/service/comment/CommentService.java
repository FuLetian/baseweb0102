package com.flt.service.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.CommentMapper;
import com.flt.dao.client.ConsumerMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.CommentExample;
import com.flt.dao.model.Consumer;
import com.flt.service.base.BaseService;
import com.flt.web.itf.dto.ConsumerCommentDTO;
import com.flt.web.itf.service.ICommentITFService;
import com.flt.web.module.views.comment.CommentConsumerDTO;
import com.flt.web.module.views.comment.ICommentService;

@Service
public class CommentService extends BaseService implements ICommentService,ICommentITFService,ICommentCommonService{

	@Override
	public List<CommentConsumerDTO> listHomePageComments(Integer max,final Integer userId) {
		// TODO Auto-generated method stub
		
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		List<Comment> list=m.selectByExample(new CommentExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
		
		if(list.size()>max.intValue()){
			list=list.subList(0, max.intValue()-1);
		}
		
		List<CommentConsumerDTO> dtos=new ArrayList<>();
		
		ConsumerMapper cm=this.getSqlSession().getMapper(ConsumerMapper.class);
		ArticleMapper am=this.getSqlSession().getMapper(ArticleMapper.class);
		for(Comment o:list){
			Consumer c=cm.selectByPrimaryKey(o.getConsumerId());
			Article a=am.selectByPrimaryKey(o.getArticleId());
			CommentConsumerDTO d=new CommentConsumerDTO(a,o,c);
			dtos.add(d);
		}
		
		return dtos;
	}

	@Override
	public List<Comment> listCommentsByArticleId(Integer articleId,
			Integer userId) {
		// TODO Auto-generated method stub
		
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		
		CommentExample ex=new CommentExample();
		ex.createCriteria().andArticleIdEqualTo(articleId).andUserIdEqualTo(userId);
		return m.selectByExample(ex);
	}

	@Override
	public List<ConsumerCommentDTO> listConsumerCommentsByArticleId(
			Integer articleId, Integer userId) {
		// TODO Auto-generated method stub
		
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		CommentExample ex=new CommentExample();
		ex.createCriteria().andArticleIdEqualTo(articleId).andUserIdEqualTo(userId);
		
		List<Comment> list=m.selectByExample(ex);
		List<ConsumerCommentDTO> results=new ArrayList<>();
		for(Comment o:list){
			ConsumerCommentDTO dto=new ConsumerCommentDTO();
			dto.setComment(o);
			
			ConsumerMapper m2=this.getSqlSession().getMapper(ConsumerMapper.class);
			dto.setConsumer(m2.selectByPrimaryKey(o.getConsumerId()));
			
			results.add(dto);
		}
		
		return results;
	}

}
