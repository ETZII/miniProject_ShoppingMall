<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />
<section>
<br><br><br>
<div align="center">

<h2>회원 가입을 환영합니다.</h2>
<img class="welcome" src=${path}/member/img/welcome.png />
</div>
</section>
<c:import url="/include/footer.jsp" />
