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

@Controller
public class CartController {
	
	@Autowired
	CartServiceImpl service;
	
	@RequestMapping("/cartOk.do")
	String insertCart(CartVO vo, Model model) {
		System.out.println("===> insertCart 실행 ");
		CartVO cart = service.isExist(vo);
		if(cart==null) {
			System.out.println("===>같은 상품 존재 X, 새로 추가");
			service.insertCart(vo);
		} else {
			System.out.println("===>같은 상품 존재 O, 수량 변경");
			vo.setCartId(cart.getCartId());
			service.insertUpdate(vo);
		}
		return "redirect:cartList.do";
	}
	
	@RequestMapping("/cartList.do")
	String selectCartList(CartVO vo, HttpSession session, Model model) {
		vo.setUserId((String) session.getAttribute("userId"));
		List<CartVO> li = service.selectCartList(vo);
		if(li.size()!=0) {
			model.addAttribute("li", li);
			model.addAttribute("sumMoney",service.sumMoney(vo));
		} else {
			model.addAttribute("sumMoney",0);
		}
		return "/cart/cart_list.jsp";
	}
	
	@RequestMapping("/cartUpdate.do")
	String updateCart(@RequestParam String[] cartId, @RequestParam int[] amount) {
		System.out.println("===>update 실행");
		for(int i=0; i< cartId.length; i++) {
			CartVO vo = new CartVO();
			vo.setCartId(cartId[i]);
			vo.setAmount(amount[i]);
			service.updateCart(vo);
		}
		return "redirect:cartList.do";
	}

	@RequestMapping("/deleteCart.do")
	String deleteCart(CartVO vo,HttpSession session) {
		service.deleteCart(vo);
		return "redirect:cartList.do";
	}
	
	@RequestMapping("/cartDeleteAll.do")
	String deleteCartAll(CartVO vo,Model model,HttpSession session) {
		vo.setUserId((String) session.getAttribute("userId"));
		service.deleteCartAll(vo);
		session.removeAttribute("sumMoney");
		session.removeAttribute("li");
		return "redirect:cartList.do";
	}
	
}
