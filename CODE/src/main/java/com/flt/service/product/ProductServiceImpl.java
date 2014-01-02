package com.flt.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flt.dao.client.ProductMapper;
import com.flt.dao.model.Product;
import com.flt.dao.model.ProductExample;
import com.flt.service.base.BaseService;
import com.flt.web.pages.controller.IPage1ProductService;

@Service
public class ProductServiceImpl extends BaseService implements IPage1ProductService {

	@Override
	public List<Product> listProductByChannelType(Integer channelType) {
		// TODO Auto-generated method stub
		ProductMapper mapper=this.getSqlSession().getMapper(ProductMapper.class);
		
		ProductExample ex=new ProductExample();
		ex.createCriteria().andChannelTypeEqualTo(channelType);
		
		return mapper.selectByExample(ex);
	}

}
