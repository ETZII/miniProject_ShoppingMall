package com.yejishop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yejishop.portfolio.cart.CartServiceImpl;
import com.yejishop.portfolio.cart.CartVO;
import com.yejishop.portfolio.payment.PaymentServiceImpl;
import com.yejishop.portfolio.payment.PaymentVO;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentServiceImpl service;
	
	@Autowired
	CartServiceImpl cartService;
	
	@RequestMapping("/PaymentOk.do")
	String insertPayment(@RequestParam String[] cartId) {
		CartVO cvo = new CartVO();
		for(int i=0; i<cartId.length; i++) {
			cvo.setCartId(cartId[i]);
			cvo = cartService.selectCart(cvo);
			service.insertPayment(cvo);
		}
		System.out.println(cvo.getUserId());
		cartService.deleteCartAll(cvo);
		System.out.println("==>삭제완료");
		return "redirect:/paymentList.do";
	}
	
	@RequestMapping("/paymentList.do")
	String selectAll(PaymentVO vo,HttpSession session,Model model) {
		vo.setUserId((String) session.getAttribute("userId"));
		List<PaymentVO> li = service.selectAll(vo);
		if(li.size()!=0) {
			model.addAttribute("li", service.selectAll(vo));
			model.addAttribute("sumPaymentMoney",service.sumPaymentMoney(vo));
		} else {
			model.addAttribute("sumPaymentMoney",0);
		}
		return "/payment/payment_list.jsp";
	}
}
