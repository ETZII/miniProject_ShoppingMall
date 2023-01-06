package com.yejishop.portfolio.member;

import java.util.List;

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

	@Override
	public void update(MemberVO vo) {
		dao.update(vo);
	}
	
	@Override
	public String idCheck(MemberVO vo) {
		return dao.idCheck(vo);
	}

	@Override
	public MemberVO getIdPwd(MemberVO vo) {
		return dao.getIdPwd(vo);
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		return dao.select(vo);
	}

	@Override
	public MemberVO selectDetail(MemberVO vo) {
		return dao.selectDetail(vo);
	}

	

}
