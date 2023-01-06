<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<c:import url="/include/header.jsp" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<section class = "member_detail">
<br>
<h2>회원 상세보기</h2>
<div>

<form action=${path}/memberEdit.do>
<table border=1>
	<tr>
		<td>회원이름</td><td>${m.userName}</td>
		<td>나 이</td><td> ${m.userAge} </td>
	</tr>
	<tr>
		<td>회원아이디</td> <td> ${m.userId} <input type="hidden" name="userId" value="${m.userId}"/></td>
	    <td>성별</td>  <td> ${m.userGender}</td>
	</tr>
	<tr>
		<td>전화번호</td> <td> ${m.userPhone} </td> 
		<td>등급</td><td>${m.userGrade}</td>
	</tr>
	<tr><td>회원주소</td> 
		<td colspan=3>[${m.userAddr1}] <br> ${m.userAddr2} &emsp;${m.userAddr3} </td>
	</tr>
	<tr><td>가입일</td> 
		<td colspan=3>${m.userRegdate}</td>
	</tr>
	<tr><td>특이사항</td> 
		<td colspan=3><textarea rows=5 cols=25 name="userEtc" >${m.userEtc}</textarea></td>
	</tr>
	<tr><td colspan=4  align="center"> 
	    <input  type=submit value="수정하기" />&emsp;
	    <input  type=button value="뒤로가기" onclick="location.href='${path}/memberList.do'" />
	   </td>
	</tr>
</table>
</form>
</div>
<br>

</section>
<c:import url="/include/footer.jsp" />
