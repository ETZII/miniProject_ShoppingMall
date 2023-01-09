package com.yejishop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yejishop.portfolio.member.MemberService;
import com.yejishop.portfolio.member.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	/* 로그인 */
	@RequestMapping("/login.do")
	String login(MemberVO vo, HttpSession session) {
		System.out.println("==> login  실행");
		MemberVO m = service.getIdPwd(vo);
		String str = "/member/login.jsp";
		
		if(m!=null) {
			if(passEncoder.matches(vo.getUserPassword(),m.getUserPassword())) {
				str = "index.jsp";
				session.setAttribute("userId", m.getUserId());
				session.setAttribute("memberGrade", m.getUserGrade());
			}
		}
		return str;
	}
	/* 로그아웃 */
	@RequestMapping("/logout.do")
	String logout(HttpSession session) {
		System.out.println("==> logout  실행");
		
		session.invalidate();  
		
		return "/member/login.jsp";
	}
	
	/* 회원가입 */
	@RequestMapping("/memberOK.do")
	String insert(MemberVO vo) {
		System.out.println("==> insert 실행");
		vo.setUserPassword(passEncoder.encode(vo.getUserPassword())); 
		service.insert(vo);
		System.out.println("insert 성공");
		return "/member/hello.jsp";
	}
	
	/* ID 확인 */
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
	
	/* 회원 조회 */
	@RequestMapping("/memberList.do")
	String memberSelect(MemberVO vo, Model model) {
		System.out.println("==> memberSelect  실행");
		model.addAttribute("cnt", service.select(vo).size());
		model.addAttribute("li", service.select(vo));
		return "/member/member_list.jsp";
	}
	@RequestMapping("/memberDetail.do")
	String memberSelectDetail(MemberVO vo, Model model) {
		System.out.println("==> memberSelectDetail  실행");
		model.addAttribute("m", service.selectDetail(vo));
		return "/member/member_detail.jsp";
	}
	
	@RequestMapping("/memberEdit.do")
	String update(MemberVO vo) {
		System.out.println("==> update  실행");
		service.update(vo);
		System.out.println("==> 업데이트 성공!");
		return "/memberList.do";
	}
	
}