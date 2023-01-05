package com.yejishop.portfolio.member;

public interface MemberService {

	void insert(MemberVO vo);
	String idCheck(MemberVO vo);
	MemberVO getIdPwd(MemberVO vo);

}
