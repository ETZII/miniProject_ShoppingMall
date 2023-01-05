package com.yejishop.portfolio.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl  implements ProductDao {

	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public void insert(ProductVO vo) {
		mybatis.insert("PRODUCT.insert", vo);
	}
	
}
