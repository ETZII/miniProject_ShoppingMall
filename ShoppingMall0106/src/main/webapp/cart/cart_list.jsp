<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" ></script>

<script src=${path}/include/main.js ></script>
<script>
function edit() {
	
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	
	var path = location.href.substring(0,location.href.indexOf('/', hostIndex + 1));
	
	var amount = $('#amount').val();
	var id = $('#userId').val();
	var cartid = $('#cartId').val();
	
	location.href=path+'/cartUpdate.do?cartId='+cartid+'&amount='+amount+'&userId='+id;
}
</script>



<c:set var= "path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />
<section class="cart_list">
<br>
<div align=center>
<h2>${userId}님의 장바구니 </h2>
<input type="hidden" id="userId" value="${userId}"/>
<table border=1>
 <tr align="center">
      <th> 상품명  </th> <th> 단가  </th> <th> 수량  </th>  <th> 총 금액  </th> 
      <th> 수량변경 및 삭제 </th>
<c:forEach items="${li}"  var="c" >

 <tr>  
      <td>${c.pdName}</td>
      <td><fmt:formatNumber value="${c.pdPrice}" pattern=",000"/>원 </td>
      <td> <input type="text" size= 2 id="amount" value="${c.amount}"/> </td>
      <td><fmt:formatNumber value="${c.money}" pattern=",000"/>원 </td>
      <td> <input type="hidden" id="cartId" value="${c.cartId}"/>
      	  &emsp;<input type="button" value="변경" onclick="edit()"/>
      	  &emsp;<input type="button" value="삭제" onclick="location.href='javascript:void(0)'" /></td>
 </tr> 
</c:forEach>
 <tr>
 	<td colspan="5" align="right">총 금액 : <fmt:formatNumber value="${sumMoney}" pattern=",000"/>원&emsp;&emsp; <input type="submit" value="구매하기" /></td>
 </tr>
 </table>

</div>
</section>
<c:import url="/include/footer.jsp" />