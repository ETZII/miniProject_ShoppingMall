<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" ></script>

<c:set var= "path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />

<script>
function deleteCart(cartId) {
	location.href="${path}/deleteCart.do?cartId="+cartId;
}
</script>

<section class="cart_list">
<br>
<div align=center>
<h2>${userId}님의 장바구니 </h2>
<input type="hidden" id="userId" value="${userId}"/>
<form method=post  name="form">
<table border=1>
 <tr align="center">
      <th>번 호</th><th> 상품명  </th> <th> 단 가  </th> <th> 수 량  </th>  <th> 총 금액  </th> <th> 삭제 </th> 
 </tr>
<c:forEach items="${li}"  var="c" >
 <tr>  
 	  <td>${c.cartId}<input type="hidden" name="cartId" value="${c.cartId}"/></td>
      <td>${c.pdName}</td>
      <td><fmt:formatNumber value="${c.pdPrice}" pattern="#,###"/>원 </td>
      <td> <input type="text" size= 2 name="amount" value="${c.amount}"/> </td>
      <td><fmt:formatNumber value="${c.money}" pattern="#,###"/>원 </td>
      <td align="center"><input type="button" value="삭제" onclick="deleteCart(${c.cartId})" /></td>
 </tr> 
</c:forEach>
<tr>
	<td colspan=6 align="right">
		<input type="submit" value="수량변경" onclick="javascript:action='${path}/cartUpdate.do'"/>
		<input type="button" value="장바구니비우기" onclick="location.href='${path}/cartDeleteAll.do'"/>
	&emsp;</td>
</tr>
 <tr>
 	<td colspan="6" align="right">총 금액 : 
 		<fmt:formatNumber value="${sumMoney}" pattern="#,###"/>원&emsp;&emsp; 
 	<input type="submit" value="구매하기" onclick="javascript:action='${path}/PaymentOk.do'" /></td>
 </tr>
 </table>
 </form>

</div>
</section>
<c:import url="/include/footer.jsp" />