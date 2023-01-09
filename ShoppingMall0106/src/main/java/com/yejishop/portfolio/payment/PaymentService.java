package com.yejishop.portfolio.payment;

import com.yejishop.portfolio.cart.CartVO;

public interface PaymentService {

	void insertPayment(CartVO vo);

}
