package com.yejishop.portfolio.payment;

import com.yejishop.portfolio.cart.CartVO;

public interface PaymentDao {

	void insertPayment(CartVO vo);
}
