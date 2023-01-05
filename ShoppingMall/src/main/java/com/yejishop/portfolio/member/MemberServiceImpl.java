package com.yejishop.portfolio.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

}