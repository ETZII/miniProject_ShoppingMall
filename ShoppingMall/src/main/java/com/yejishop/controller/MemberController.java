package com.yejishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yejishop.portfolio.member.MemberService;
import com.yejishop.portfolio.member.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@RequestMapping("/memberOK.do")
	String insert(MemberVO vo) {
		System.out.println("==> insert 실행");
		vo.setUserPassword(passEncoder.encode(vo.getUserPassword())); 
		service.insert(vo);
		System.out.println("insert 성공");
		return "/member/hello.jsp";
	}
	
}