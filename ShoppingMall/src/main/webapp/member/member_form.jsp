<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<c:import url="/include/header.jsp" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src=${path}/include/main.js ></script>

<script src="http://code.jquery.com/jquery-1.10.2.js" ></script>
<script>
jQuery.ajaxSetup({cache:false});

function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
/*
$(document).ready( function(){
	  $('#idCheck').click( function(){	
		  var path = getContextPath();
		  var  dataStr={
				  userId : $('#userId').val()			  
		  };
		  		 
		  $.ajax({			 
			  type: "GET",
			  url :  path+"/idCheck.do",
			  data : dataStr,
			  success: function (data){
			   if(data == "null"){
				   alert("사용가능한 아이디 입니다.!!"); 
			   } else {
				   alert(data+"는 벌써 사용하고 있습니다.!!");
				   $('#userId').val("");
				   $('#userId').focus();
			   }
			  }	  
		  })
	  }) 
})
*/
</script>



<section>
<br>
<div align=center>
<h2>쇼핑몰 회원가입</h2>
<form name=f1 action=${path}/memberOK.do method="post" onSubmit="return ch1()"  >
<table border=1 width=650 height=400>
<tr><td align="center">회원이름</td>  <td> &emsp;<input type=text name=userName  /> </td>
<td align="center">나이</td>  <td>&emsp;<input type=text name=userAge  /> </td></tr>
<tr><td align="center">회원아이디  </td>
    <td>&emsp;<input type=text name=userId id="userId" /> 
              <input type=button id="idCheck" value="중복확인">  </td>
    <td align="center">성별</td>  <td>
    &emsp;<input type=radio name=userGender value="남" checked  /> 남
    <input type=radio name=userGender value="여"  /> 여</td></tr>
<tr><td align="center">패스워드</td>  <td colspan=3>&emsp;<input type=text name=userPassword  /> </td></tr>
<tr><td align="center">전화번호</td>  <td colspan=3>&emsp;<input type=text name=userPhone size=40 /> </td></tr>
<tr><td align="center">회원주소</td> 
 <td colspan=3>
 
<table border=1>
<tr> <td align="left"> 
<input type="text" id="sample6_postcode"  name=userAddr1  placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
</td></tr>
<tr> <td align="left"> 
<input type="text" id="sample6_address" placeholder="주소"  size=80 name=userAddr2><br>
</td></tr>
<tr> <td align="left"> 
<input type="text" id="sample6_detailAddress" placeholder="상세주소" size=40 name=userAddr3>
<input type="text" id="sample6_extraAddress" placeholder="참고항목"  size=30 name=userAddr4>
</td></tr>
</table>
</td></tr>
<tr><td colspan=5  align="center"> 
    <input  type=submit value="회원가입">&emsp;
    <input  type=button value="다시작성">
   </td></tr>
</table>
</form>
</div>
<br>



<script>
function ch1() {
	if(f1.userName.value==""){
	  alert("이름을 입력해 주세요");
	  f1.userName.focus();
	  return false;
	}
	if(f1.userId.value==""){
	  alert("아이디를 입력해 주세요");
	  f1.userId.focus();
	  return false;
	}
	if(f1.userPassword.value==""){
	  alert("암호를 입력해 주세요");
	  f1.userPassword.focus();
	  return false;	
	}	  
}
</script>

</section>
<c:import url="/include/footer.jsp" />
