package com.flt.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.CommentMapper;
import com.flt.dao.client.OrderMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.CommentExample;
import com.flt.dao.model.Order;
import com.flt.dao.model.OrderExample;
import com.flt.service.base.BaseService;
import com.flt.web.pages.page6.OrderArticleDTO;
import com.flt.web.pages.page6.service.IPage6OrderService;

@Service
public class OrderArticleService extends BaseService implements IPage6OrderService {

	
	@Override
	public List<OrderArticleDTO> listOrderArticleDTOsByRunStatus(
			Integer runStatus,Integer consumerId) {
		// TODO Auto-generated method stub
		
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		if(runStatus!=null){
			ex.createCriteria().andRunStatusEqualTo(runStatus).andConsumerIdEqualTo(consumerId);
		}else{
			ex.createCriteria().andConsumerIdEqualTo(consumerId);
		}
		ArticleMapper m2=this.getSqlSession().getMapper(ArticleMapper.class);
		
		CommentMapper m3=this.getSqlSession().getMapper(CommentMapper.class);
		CommentExample ex3=new CommentExample();
		
		List<Order> list=m.selectByExample(ex);
		List<OrderArticleDTO> results=new ArrayList<>();
		for(Order o:list){
			
			Article a=m2.selectByPrimaryKey(o.getArticleId());
			
			ex3.createCriteria().andConsumerIdEqualTo(consumerId).andArticleIdEqualTo(a.getId());
			List<Comment> comments=m3.selectByExample(ex3);
			Comment comment=null;
			if(comments.isEmpty()){
				comment=new Comment();
			}else{
				comment=comments.get(0);
			}
			
			OrderArticleDTO dto=new OrderArticleDTO();
			dto.setOrder(o);
			dto.setArticle(a);
			dto.setComment(comment);
			
			results.add(dto);
		}
		return results;
	}

	@Override
	public void addCommentForArticle(String content, Integer grade,
			Integer consumerId,Integer articleId, Integer userId) {
		// TODO Auto-generated method stub
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		CommentExample ex=new CommentExample();
		
		ex.createCriteria().andArticleIdEqualTo(articleId).andConsumerIdEqualTo(consumerId).andUserIdEqualTo(userId);
		List<Comment> cs=m.selectByExample(ex);
		
		Comment c=new Comment();
		if(!cs.isEmpty()){
			c=cs.get(0);
		}
		c.setContent(content);
		c.setGrade(grade);
		c.setConsumerId(consumerId);
		c.setUserId(userId);
		c.setArticleId(articleId);
		c.setcDt(new Date());
		c.setuDt(new Date());
		
		if(c.getId()==null){
			m.insert(c);
		}else{
			m.updateByPrimaryKey(c);
		}
	}

	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		
		m.deleteByPrimaryKey(orderId);
	}

	@Override
	public void setRunStatus(Integer orderId, Integer runStatus) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);	
		
		Order o=m.selectByPrimaryKey(orderId);
		o.setRunStatus(runStatus);
		
		m.updateByPrimaryKey(o);
	}

}
