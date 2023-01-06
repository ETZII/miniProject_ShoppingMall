package com.yejishop.portfolio.product;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {

	private String pdId;
	private String pdType;
	private String pdName;
	private int pdPrice;
	private String pdExplain;
	private String pdImgstr;
	private String pdShow;
	private String searchCondition;
	private String searchKeyword;
	private String searchPrice1;
	private String searchPrice2;
	
	private MultipartFile pdImg;
	
	
	private  int pageSize;
	private  int pageListSize;
	private  int totalCount;
	private  int totalPage;
	private  int start;
	private  int nowPage;
	private  int listStartpage;
	private  int listEndPage;
	private  int endPage;
}
