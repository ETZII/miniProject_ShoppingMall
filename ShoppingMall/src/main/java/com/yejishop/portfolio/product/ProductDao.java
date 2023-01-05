package com.yejishop.portfolio.product;

import java.util.List;


public interface ProductDao {
	void insert (ProductVO vo);
	
	List<ProductVO> select(ProductVO vo,String grade);

//	페이징처리
	// 게시물 총 갯수
	int totalCount(String adminChk);
}
