package com.yejishop.portfolio.payment;

import lombok.Data;

@Data
public class PaymentVO {
	private String paymentId;
	private String cartId;
	private String userId;
	private String payDate;
	private String isRefund;
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
