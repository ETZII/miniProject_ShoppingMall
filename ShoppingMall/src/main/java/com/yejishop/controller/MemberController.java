package com.yejishop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/idCheck.do")
	void idCheck(HttpServletResponse  response, MemberVO vo) {
		System.out.println("==> idCheck  실행");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(service.idCheck(vo));
	}
	
	@RequestMapping("/login.do")
	String login(MemberVO vo, HttpSession session) {
		System.out.println("==> login  실행");
		MemberVO m = service.getIdPwd(vo);
		String str = "/member/login.jsp";
		
		if(m!=null) {
			if(passEncoder.matches(vo.getUserPassword(),m.getUserPassword())) {
				str = "index.jsp";
				session.setAttribute("memberId", m.getUserId());
				session.setAttribute("memberGrade", m.getUserGrade());
			}
		}
		return str;
	}
	
	@RequestMapping("/logout.do")
	String logout(HttpSession session) {
		System.out.println("==> logout  실행");
		
		session.removeAttribute("memberId");
		session.removeAttribute("memberGrade");
		
		return "index.jsp";
	}
	
}