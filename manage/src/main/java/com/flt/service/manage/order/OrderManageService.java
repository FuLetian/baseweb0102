package com.flt.service.manage.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ArticleMapper;
import com.flt.dao.client.ConsumerMapper;
import com.flt.dao.client.OrderMapper;
import com.flt.dao.model.Order;
import com.flt.dao.model.OrderExample;
import com.flt.dao.model.OrderExample.Criteria;
import com.flt.service.manage.base.BaseManageService;
import com.flt.web.manage.order.dto.OrderConsumerDTO;
import com.flt.web.manage.order.service.IOrderService;

@Service
public class OrderManageService extends BaseManageService implements IOrderService {

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

}
