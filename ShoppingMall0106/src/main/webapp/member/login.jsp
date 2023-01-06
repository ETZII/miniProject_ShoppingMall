<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<c:import url="/include/header.jsp" />
<c:set var="path" value="${pageContext.request.contextPath}" />


<section>
<br>
<div align=center>
<h2>쇼핑몰 로그인 </h2>
<form name=f1 action=${path}/login.do method="post" >
<table border=1 >
<tr><td align="center" width="100px">아이디</td><td><input type=text name=userId size=20/> </td></tr>
<tr><td align="center">패스워드</td>  <td><input type=password name=userPassword size=21 /> </td></tr>
<tr><td colspan=2  align="center"> 
    <input  type=submit value="로그인">&emsp;
    <input  type=button value="회원가입" onclick="location.href='${path}/member/member_form.jsp'">
   </td></tr>
</table>
</form>
</div>
<br>

</section>
<c:import url="/include/footer.jsp" />
