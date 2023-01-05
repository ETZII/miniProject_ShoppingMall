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
	
	private MultipartFile pdImg;
	
}
