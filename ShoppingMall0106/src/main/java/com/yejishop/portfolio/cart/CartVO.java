package com.yejishop.portfolio.cart;

import lombok.Data;

@Data
public class CartVO {
	private String cartId;       // 장바구니 번호
	private String userId;       // 사용자 아이디
	private String userName ;    // 사용자 이름 
	private String pdId;    	 // 상품 번호
	private String  pdName;		 // 상품이름
	private int pdPrice;    // 상품단가
	private int amount ;         // 상품수량
	private int money;           // 상품금액
	  
	public int getMoney() {
		money =  pdPrice * amount;
		return money;
	}
}