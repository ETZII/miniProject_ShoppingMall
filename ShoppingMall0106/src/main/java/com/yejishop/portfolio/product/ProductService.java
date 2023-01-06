package com.yejishop.portfolio.product;

import java.util.List;


public interface ProductService {
	void insert (ProductVO vo);
	
	List<ProductVO> select(ProductVO vo,String grade);
	ProductVO selectOne (ProductVO vo);
	
	int totalCount(String adminChk);
}
