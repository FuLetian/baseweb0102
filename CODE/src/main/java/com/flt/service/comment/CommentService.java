package com.flt.service.comment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.CommentMapper;
import com.flt.dao.model.Comment;
import com.flt.dao.model.CommentExample;
import com.flt.service.base.BaseService;
import com.flt.web.module.views.comment.ICommentService;

@Service
public class CommentService extends BaseService implements ICommentService{

	@Override
	public List<Comment> listHomePageComments(Integer max,final Integer userId) {
		// TODO Auto-generated method stub
		
		CommentMapper m=this.getSqlSession().getMapper(CommentMapper.class);
		List<Comment> list=m.selectByExample(new CommentExample(){{
			this.createCriteria().andUserIdEqualTo(userId);
		}});
		
		if(list.size()>5){
			return list.subList(0, 4);
		}
		return list;
	}

}
