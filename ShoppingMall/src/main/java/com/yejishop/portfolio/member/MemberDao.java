package com.yejishop.portfolio.member;

public interface MemberDao {

	void insert(MemberVO vo);
	String idCheck(MemberVO vo);
	MemberVO getIdPwd(MemberVO vo);
}
