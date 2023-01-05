package com.yejishop.portfolio.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(MemberVO vo) {
		mybatis.insert("MEMBER.insert", vo);
	}

}