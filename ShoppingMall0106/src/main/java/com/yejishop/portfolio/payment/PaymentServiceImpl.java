package com.yejishop.portfolio.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yejishop.portfolio.cart.CartVO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao dao;
	
	@Override
	public void insertPayment(CartVO vo) {
		dao.insertPayment(vo);
	}

}
