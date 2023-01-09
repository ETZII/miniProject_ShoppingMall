package com.yejishop.portfolio.payment;

import java.util.List;

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

	@Override
	public List<PaymentVO> selectAll(PaymentVO vo) {
		return mybatis.selectList("PAYMENTS.selectAll", vo);
	}

	@Override
	public int sumPaymentMoney(PaymentVO vo) {
		return mybatis.selectOne("PAYMENTS.paymentSumMoney", vo);
	}
	
}
