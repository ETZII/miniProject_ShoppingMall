package com.yejishop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yejishop.portfolio.product.ProductServiceImpl;
import com.yejishop.portfolio.product.ProductVO;

@Controller
public class ProductController {

	private String path ="";
	private SimpleDateFormat daytime;
	
	public ProductController() {
		daytime = new SimpleDateFormat("HHmmss");
	}
	
	@Autowired
	ProductServiceImpl service;
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	@PostConstruct 
	public void init() {
		path = servletContext.getRealPath("/product/files/");
	}
	
	
	@RequestMapping("/productOK.do")
	String  memberOk( Model model, ProductVO vo  ) throws Exception {
    	System.out.println("path:"+path);
    	
		MultipartFile updateFile =vo.getPdImg();
		String fileName=updateFile.getOriginalFilename();
		File f=new File(path+fileName);
		
		if( !updateFile.isEmpty()) {
			if (f.exists()) {
			  String onlyFileName =fileName.substring(0,fileName.lastIndexOf(".")); 
			  String extension =fileName.substring(fileName.lastIndexOf(".")); 
			  fileName=onlyFileName+"_"+daytime.format(System.currentTimeMillis())+extension;
			}
			updateFile.transferTo(new File(path+fileName));		  
		} else {
			 fileName= "default.png"; // 첨부파일이 없어면 ...
		}		
		vo.setPdImgstr(fileName);
    	service.insert(vo);
		return "index.jsp";	
//		return "productList.do";	
		
	}
}
