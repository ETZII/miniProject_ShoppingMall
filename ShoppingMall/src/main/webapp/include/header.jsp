<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/include/main.css">

<title>예지's 미니프로젝트</title>


</head>
<body>

<header>
 <b> 미니프로젝트 yeji's 쇼핑몰 회원관리 </b>
</header>
<nav>
<c:if test="${not empty memberId}">
	&emsp;${memberId}님 환영합니다 &emsp; 
	<a href="${path}/logout.do">로그아웃</a>
</c:if>
<c:if test="${empty memberId}">
	&emsp;&emsp;<a href="${path}/member/login.jsp">로그인</a>
	&emsp;&emsp;<a href="${path}/member/member_form.jsp">회원가입</a>
</c:if>
<c:if test="${memberGrade eq 'admin'}">
	&emsp;&emsp;<a href="${path}/memberList.do">회원목록</a>
	&emsp;&emsp;<a href="${path}/product/product_form.jsp">상품등록</a>
</c:if>
	&emsp;&emsp;<a href="${path}/productList.do">상품조회</a>
	&emsp;&emsp;<a href="javascript:void(0)">장바구니</a>
	&emsp;&emsp;<a href="javascript:void(0)">결제내역</a>
	&emsp;&emsp;<a href="${path}/index.jsp">홈으로.</a>
</nav>