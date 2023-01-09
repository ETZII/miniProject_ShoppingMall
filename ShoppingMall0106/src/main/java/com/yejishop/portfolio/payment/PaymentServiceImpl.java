package com.yejishop.portfolio.payment;

import java.util.List;

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

	@Override
	public List<PaymentVO> selectAll(PaymentVO vo) {
		return dao.selectAll(vo);
	}

	@Override
	public int sumPaymentMoney(PaymentVO vo) {
		return dao.sumPaymentMoney(vo);
	}

}
