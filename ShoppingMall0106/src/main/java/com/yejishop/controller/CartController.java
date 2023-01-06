package com.yejishop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yejishop.portfolio.cart.CartServiceImpl;
import com.yejishop.portfolio.cart.CartVO;

@Controller
public class CartController {
	
	@Autowired
	CartServiceImpl service;
	
	@RequestMapping("/cartOk.do")
	String insertCart(CartVO vo, Model model) {
		model.addAttribute("userId", vo.getUserId());
		service.insertCart(vo);
		return "redirect:cartList.do";
	}
	
	@RequestMapping("/cartList.do")
	String selectCartList(CartVO vo, Model model) {
		
		model.addAttribute("li", service.selectCartList(vo));
		model.addAttribute("sumMoney",service.sumMoney(vo));
		return "/cart/cart_list.jsp";
	}
	
	@RequestMapping("/cartUpdate.do")
	String updateCart(CartVO vo, Model model) {
		service.updateCart(vo);
		model.addAttribute("userId",vo.getUserId());
		return "redirect:cartList.do";
	}

}
