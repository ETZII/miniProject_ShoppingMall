package com.yejishop.portfolio.cart;

import java.util.List;

public interface CartDao {
	
	void insertCart(CartVO vo);
	int updateCart(CartVO vo);
	
	List<CartVO> selectCartList(CartVO vo);
	
	int sumMoney(CartVO vo);

}
