package com.yejishop.portfolio.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao dao;

	@Override
	public void insertCart(CartVO vo) {
		dao.insertCart(vo);
	}

	@Override
	public List<CartVO> selectCartList(CartVO vo) {
		return dao.selectCartList(vo);
	}

	@Override
	public int sumMoney(CartVO vo) {
		return dao.sumMoney(vo);
	}

	@Override
	public int updateCart(CartVO vo) {
		return dao.updateCart(vo);
	}
}
