package com.yejishop.portfolio.product;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl  implements ProductDao {

	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public void insert(ProductVO vo) {
		mybatis.insert("PRODUCTS.insert", vo);
	}

	@Override
	public List<ProductVO> select(ProductVO vo,String grade) {
		List<ProductVO> li = mybatis.selectList("PRODUCTS.getProductListY", vo);
		if(grade==null) {
		}else if(grade.equals("admin")) {
			li = mybatis.selectList("PRODUCTS.getProductListAll", vo);
		}
		return li;
	}

	@Override
	public int totalCount(String adminChk) {
		
		int result = mybatis.selectOne("PRODUCTS.countYProduct");
		if(adminChk==null) {
			
		}else if(adminChk.equals("admin")) {
			result = mybatis.selectOne("PRODUCTS.countAllProduct");
		}
		return result;
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		return mybatis.selectOne("PRODUCTS.getproductDetail", vo);
	}
}
