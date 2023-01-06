<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<c:import url="/include/header.jsp" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<section class = "product_detail">
<br>
<h2>제품 상세</h2>
<div>

<form action="${path}/cartOk.do">
<input type="hidden" name="userId" value="${userId}"/>
<table border=1>
	<tr>
		<td>상품번호</td><td>${p.pdId}<input type="hidden" name="pdId" value="${p.pdId}"/></td>
		<td>제품타입</td>
		<c:if test="${p.pdType eq 'monitor'}"><td> 모니터 </td></c:if>
     	<c:if test="${p.pdType eq 'keyboard'}"><td> 키보드 </td></c:if>
     	<c:if test="${p.pdType eq 'speaker'}"><td> 스피커 </td></c:if>
		<td>가격</td><td><fmt:formatNumber value="${p.pdPrice}" pattern=",000"/> 원 
		<input type="hidden" name="pdPrice" value="${p.pdPrice}"/>
		</td>
		
		<td rowspan=3><img alt="${p.pdImgstr}" src="${path}/product/files/${p.pdImgstr}" id="pdImgDetail"></td>
		
	</tr>
	<tr>
	    <td>상품명</td>  <td colspan=5> ${p.pdName} <input type="hidden" name="pdName" value="${p.pdName}"/> </td>
	</tr>
	<tr><td>상품설명</td> 
		<td colspan=5>${p.pdExplain}</td>
	</tr>
	<tr><td colspan=7  align="center"> 
		수량 &emsp;<input type=text name="amount" />개&emsp;
	    <input  type=submit value="장바구니담기" size="3" />&emsp;
	    <input  type=button value="뒤로가기" onclick="location.href='${path}/productList.do'" />
	   </td>
	</tr>
</table>
</form>
</div>
<br>

</section>
<c:import url="/include/footer.jsp" />
