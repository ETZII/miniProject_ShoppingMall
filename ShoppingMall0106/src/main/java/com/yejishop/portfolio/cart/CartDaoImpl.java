package com.yejishop.portfolio.cart;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public void insertCart(CartVO vo) {
		mybatis.insert("CARTS.insert", vo);
	}

	@Override
	public List<CartVO> selectCartList(CartVO vo) {
		return mybatis.selectList("CARTS.selectCart", vo);
	}

	@Override
	public int sumMoney(CartVO vo) {
		return mybatis.selectOne("CARTS.sumMoney", vo);
	}
	
	@Override
	public int updateCart(CartVO vo) {
		return mybatis.update("CARTS.update", vo);
	}

	@Override
	public CartVO isExist(CartVO vo) {
		return mybatis.selectOne("CARTS.isExist", vo);
	}

	@Override
	public int insertUpdate(CartVO vo) {
		return mybatis.update("CARTS.insertUpdate", vo);
	}

	@Override
	public void deleteCart(CartVO vo) {
		mybatis.delete("CARTS.delete", vo);
	}

	@Override
	public void deleteCartAll(CartVO vo) {
		mybatis.delete("CARTS.deleteAll", vo);
	}
	

}
