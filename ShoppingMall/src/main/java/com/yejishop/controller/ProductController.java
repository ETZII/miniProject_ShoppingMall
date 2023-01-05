package com.yejishop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//		return "index.jsp";	
		return "productList.do";	
	}
	
	@RequestMapping("/productList.do")
	String productList(HttpSession session, Model model, ProductVO vo) {
		System.out.println("===> productList 실행");
		System.out.print("vo.getStart():" + vo.getStart());
	   	int  pageSize=10;
	   	int  pageListSize = 5;
	   	int  start = 0;
	   	
	    if (vo.getStart() == 0) {
  		  start = 1;  
	  	}else {
	  	  start = vo.getStart();
	  	}
  	  
	  	int  totalCount=service.totalCount((String) session.getAttribute("memberId"));  
	  	int  totalPage =(int) (Math.ceil((double) totalCount / pageSize));  
	  	int  nowPage = start / pageSize + 1 ;
	  	int  listStartpage =  (nowPage - 1) / pageListSize * pageListSize + 1;
	  	int  listEndPage = listStartpage + pageListSize - 1 ;
	  	int  endPage = (totalPage - 1) * pageSize + 1 ; 
	  	
	  	vo.setPageSize(pageSize) ;
	  	vo.setPageListSize(pageListSize);
	  	vo.setTotalCount(totalCount);
	  	vo.setTotalPage(totalPage);
	  	vo.setStart(start);
	  	vo.setNowPage(nowPage);
	  	vo.setListStartpage(listStartpage);
	  	vo.setListEndPage(listEndPage);
	  	vo.setEndPage(endPage);
		
	  	model.addAttribute("m", vo);
	  	model.addAttribute("li", service.select(vo,(String) session.getAttribute("memberId")));
		return "/product/product_list.jsp";
	}

}
