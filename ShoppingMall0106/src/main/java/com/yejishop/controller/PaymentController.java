package com.yejishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yejishop.portfolio.cart.CartVO;
import com.yejishop.portfolio.payment.PaymentServiceImpl;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentServiceImpl service;
	
	@RequestMapping("/PaymentOk.do")
	String insertPayment(CartVO vo) {
		System.out.println("Payment 삽입===> vo: "+vo);
		service.insertPayment(vo);
		return "index.jsp";
	}

}
