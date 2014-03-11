package com.flt.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.common.constant.FieldConstant;
import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.CommentMapper;
import com.flt.dao.client.ConsumerMapper;
import com.flt.dao.client.OrderMapper;
import com.flt.dao.model.Article;
import com.flt.dao.model.Comment;
import com.flt.dao.model.CommentExample;
import com.flt.dao.model.Order;
import com.flt.dao.model.OrderExample;
import com.flt.dao.model.OrderExample.Criteria;
import com.flt.dto.OrderArticleComment;
import com.flt.service.base.BaseService;
import com.flt.web.manage.order.dto.OrderConsumerDTO;
import com.flt.web.manage.order.service.IOrderManageService;
import com.flt.web.pages.page6.OrderArticleDTO;
import com.flt.web.pages.page6.service.IPage6OrderService;

@Service
public class OrderArticleService extends BaseService implements IPage6OrderService,IOrderManageService,IOrderCommonService {

	
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

	@Override
	public List<OrderConsumerDTO> listOrderConsumerDTOs(Order orderCondition) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		
		Criteria c=ex.createCriteria();
		ex.setOrderByClause("id DESC");
		if(orderCondition!=null){
			Integer runStatus=orderCondition.getRunStatus();
			if(runStatus!=null){
				c.andRunStatusEqualTo(runStatus);
			}
		}
		
		ConsumerMapper m2=this.getSqlSession().getMapper(ConsumerMapper.class);
		
		ArticleMapper m3=this.getSqlSession().getMapper(ArticleMapper.class);
		
		List<Order> orders=m.selectByExample(ex);
		List<OrderConsumerDTO> list=new ArrayList<>();
		for(Order o:orders){
			OrderConsumerDTO dto=new OrderConsumerDTO();
			dto.setOrder(o);
			dto.setConsumer(m2.selectByPrimaryKey(o.getConsumerId()));
			dto.setArticle(m3.selectByPrimaryKey(o.getArticleId()));
			list.add(dto);
		}
		return list;
	}

	@Override
	public void updateRunStatus(Integer orderId, Integer runStatus) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		
		Order o=m.selectByPrimaryKey(orderId);
		
		o.setRunStatus(runStatus);
		
		m.updateByPrimaryKey(o);
	}

	@Override
	public void saveOrder(Order o) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		m.insert(o);
	}

	@Override
	public List<Order> listOrderByRunStatus(Integer runstatus,Integer articleId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		ex.createCriteria().andRunStatusEqualTo(runstatus).andArticleIdEqualTo(articleId);
		return m.selectByExample(ex);
	}

	@Override
	public Boolean saveOrUpdateOrder(Order order) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		
		if(FieldConstant.order.runStatus.collections.intValue()==order.getRunStatus().intValue()){
			ex.createCriteria().andArticleIdEqualTo(order.getArticleId()).andConsumerIdEqualTo(order.getConsumerId()).andRunStatusEqualTo(order.getRunStatus());
			List<Order> dbOrder=m.selectByExample(ex);
			if(!dbOrder.isEmpty()){
				return false;
			}else{
				order.setcDt(new Date());
				order.setuDt(new Date());
				
				m.insert(order);
			}
		}else{
			if(order.getId()==null){
				order.setcDt(new Date());
				order.setuDt(new Date());
				m.insert(order);
			}else{
				order.setuDt(new Date());
				m.updateByPrimaryKey(order);
			}
		}
		return true;
	}

	@Override
	public int countOrderByRunStatus(Integer runStatus, Integer consumerId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		
		ex.createCriteria().andRunStatusEqualTo(runStatus).andConsumerIdEqualTo(consumerId);
		return m.countByExample(ex);
	}

	@Override
	public List<OrderArticleComment> listCOnsumerOrderByRunStatus(Integer runstatus,
			Integer consumerId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		OrderExample ex=new OrderExample();
		
		ex.createCriteria().andRunStatusEqualTo(runstatus).andConsumerIdEqualTo(consumerId);
		
		List<Order> orders= m.selectByExample(ex);
		
		List<OrderArticleComment> list=new ArrayList<>();
		for(Order o:orders){
			ArticleMapper m2=this.getSqlSession().getMapper(ArticleMapper.class);
			Article a=m2.selectByPrimaryKey(o.getArticleId());
			
			OrderArticleComment oa=new OrderArticleComment();
			oa.setArticle(a);
			oa.setOrder(o);
			list.add(oa);
		}
		
		return list;
	}

	@Override
	public OrderArticleComment loadOrderArticleByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		ArticleMapper m2=this.getSqlSession().getMapper(ArticleMapper.class);
		
		Order order=m.selectByPrimaryKey(orderId);
		Article article=m2.selectByPrimaryKey(order.getArticleId());
		
		OrderArticleComment oa=new OrderArticleComment();
		oa.setArticle(article);
		oa.setOrder(order);
		
		return oa;
	}

	@Override
	public OrderArticleComment loadOrderArticleByOrderId(Integer orderId,
			Integer consumerId) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		ArticleMapper m2=this.getSqlSession().getMapper(ArticleMapper.class);
		
		Order order=m.selectByPrimaryKey(orderId);
		Article article=m2.selectByPrimaryKey(order.getArticleId());
		
		CommentMapper m3=this.getSqlSession().getMapper(CommentMapper.class);
		CommentExample ex3=new CommentExample();
		ex3.createCriteria().andArticleIdEqualTo(order.getArticleId()).andConsumerIdEqualTo(consumerId);
		List<Comment> comments=m3.selectByExample(ex3);
		
		OrderArticleComment oa=new OrderArticleComment();
		oa.setArticle(article);
		oa.setOrder(order);
		
		if(comments.isEmpty()){
			oa.setComment(null);
		}else{
			oa.setComment(comments.get(0));
		}
		return oa;
	}

	@Override
	public Order loadOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().getMapper(OrderMapper.class).selectByPrimaryKey(orderId);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		OrderMapper m=this.getSqlSession().getMapper(OrderMapper.class);
		m.updateByPrimaryKey(order);
	}



}
