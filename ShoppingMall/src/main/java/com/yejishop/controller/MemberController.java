package com.yejishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yejishop.portfolio.member.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	
}
