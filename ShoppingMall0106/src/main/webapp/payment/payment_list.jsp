<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var= "path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />

<section class="payment_list">
<br>
<div align=center>
<h2>${userId}님의 구매 목록 </h2>
<table border=1>
 <tr align="center">
      <th>상품번호</th><th> 상품명  </th> <th> 단가  </th> <th> 수량  </th>  <th> 총 금액  </th> <th> 구매일 </th>
 </tr>
<c:forEach items="${li}"  var="p" >
 <tr>  
 	  <td>${p.pdId}</td>
      <td>${p.pdName}</td>
      <td><fmt:formatNumber value="${p.pdPrice}" pattern="#,###"/>원 </td>
      <td> ${p.amount} </td>
      <td><fmt:formatNumber value="${p.money}" pattern="#,###"/>원 </td>
      <td><fmt:formatDate value="${p.payDate}" pattern="yyyy/MM/dd"/></td>
 </tr> 
</c:forEach>
 <tr>
 	<td colspan="6" align="right">총 결제금액 : 
 		<fmt:formatNumber value="${sumPaymentMoney}" pattern="#,###"/>원&emsp;&emsp; 
 	</td>
 </tr>
 </table>

</div>
</section>
<c:import url="/include/footer.jsp" />