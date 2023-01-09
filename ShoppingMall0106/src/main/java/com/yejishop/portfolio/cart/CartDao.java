package com.yejishop.portfolio.cart;

import java.util.List;

public interface CartDao {
	
	void insertCart(CartVO vo);
	int updateCart(CartVO vo);
	void deleteCart(CartVO vo);
	void deleteCartAll(CartVO vo);
	
	List<CartVO> selectCartList(CartVO vo);
	CartVO selectCart(CartVO vo);
	
	int sumMoney(CartVO vo);

	CartVO isExist(CartVO vo);
	int insertUpdate(CartVO vo);
}
