<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var= "path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />
<section class="member_list">
<br>
<div align=center>
<h2>회원 목록 </h2> &emsp; 조회 된 회원 수 : ${cnt}

<table border=1>
 <tr align="center">
      <th> 이름 </th> <th> 성별  </th>  <th> 나이  </th> <th> 아이디  </th> <th> 주소  </th> 
      
<c:forEach items="${li}"  var="m" >
 <tr>  
      <td><a href="${path}/memberDetail.do?userId=${m.userId}">${m.userName}</a></td>
      <td> ${m.userGender} </td>
      <td> ${m.userAge}   </td>
      <td> ${m.userId}   </td>
      <td> [${m.userAddr1}]  ${m.userAddr2} ${m.userAddr3} </td>
 </tr> 
</c:forEach>
 </table>

<form action=memberList.do>
 <select name=searchCondition>
  <option value='userName'> 이름 </option>
  <option value='userId'> 아이디 </option>
  <option value='userAddr2'> 주소 </option>
 </select>
 <input  type=text  name=searchKeyword>
 <input  type=submit  value="검색하기">
</form> 

</div>
</section>
<c:import url="/include/footer.jsp" />