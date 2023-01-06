<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<c:import url="/include/header.jsp" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<section class = "product_insert">
<div>
<br>
<h2>상품 등록</h2>

<form action=${path}/productOK.do method=post enctype ="multipart/form-data">
<table border=1>
	<tr><td>상품명</td><td><input type="text" name="pdName" size=36 /></td>	</tr>
	<tr>
		<td>상품 타입</td>
		<td align="left">&emsp;
			<select name="pdType">
				<option value="monitor">모니터</option>
				<option value="keyboard">키보드</option>
				<option value="speaker">스피커</option>
			</select> 
		</td>
	</tr>
	<tr><td>상품 가격</td> <td align="left">&emsp;<input type="text" name="pdPrice"/> 원</td></tr>
	<tr><td>상품 설명</td> <td>	<textarea rows="5" cols="31" name="pdExplain"></textarea></td></tr>
	<tr><td>상품 이미지</td><td><input type="file" name="pdImg"/></td></tr>
	<tr><td colspan=2  align="center"> 
	    <input  type=submit value="등록하기" />&emsp;
	    <input  type=reset value="다시입력" />
	   </td>
	</tr>
</table>
</form>
<br>

</div>
</section>
<c:import url="/include/footer.jsp" />
