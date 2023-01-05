package com.yejishop.portfolio.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	@Override
	public void insert(ProductVO vo) {
		dao.insert(vo);
	}
	
	
}
