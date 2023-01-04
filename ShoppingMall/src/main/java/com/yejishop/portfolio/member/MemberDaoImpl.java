package com.yejishop.portfolio.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession mybatis;
	
	@Override
	public void insert(MemberVO vo) {
		mybatis.insert("MEMBER.insert", vo);
	}

}
