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
&emsp;&emsp;<a href="${path}/member/member_form.jsp">회원가입</a>

&emsp;&emsp;<a href="${path}/index.jsp">홈으로.</a>
</nav>