package com.yejishop.portfolio.product;

import java.util.List;

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

	@Override
	public List<ProductVO> select(ProductVO vo,String grade) {
		return dao.select(vo,grade);
	}

	@Override
	public int totalCount(String adminChk) {
		return dao.totalCount(adminChk);
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		return dao.selectOne(vo);
	}

	
}
