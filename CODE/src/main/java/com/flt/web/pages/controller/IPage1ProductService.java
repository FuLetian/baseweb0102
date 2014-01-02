package com.flt.web.pages.controller;

import java.util.List;

import com.flt.dao.model.Product;

public interface IPage1ProductService {

	List<Product> listProductByChannelType(Integer channelType);
}
