package com.yejishop.portfolio.member;

import java.util.List;

public interface MemberService {

	void insert(MemberVO vo);
	void update(MemberVO vo);

	String idCheck(MemberVO vo);
	MemberVO getIdPwd(MemberVO vo);

	List<MemberVO> select(MemberVO vo);
	MemberVO selectDetail(MemberVO vo);
}
