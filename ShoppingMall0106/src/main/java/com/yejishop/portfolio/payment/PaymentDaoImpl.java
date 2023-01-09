package com.yejishop.portfolio.payment;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejishop.portfolio.cart.CartVO;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public void insertPayment(CartVO vo) {
		mybatis.insert("PAYMENTS.insert", vo);
	}
}
