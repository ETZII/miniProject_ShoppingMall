package com.yejishop.portfolio.payment;

import java.util.List;

import com.yejishop.portfolio.cart.CartVO;

public interface PaymentDao {

	void insertPayment(CartVO vo);
	
	List<PaymentVO> selectAll(PaymentVO vo);
	
	int sumPaymentMoney(PaymentVO vo);
}
