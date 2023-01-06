<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var= "path" value="${pageContext.request.contextPath}" />
<c:import url="/include/header.jsp" />
<section class="product_list">
<br>
<div align=center>
<h2>상품 목록 </h2>

<table border=1>
 <tr align="center">
      <th> 번호  </th><th> 사진 </th> <th> 타입  </th>  <th> 상품명  </th> <th> 가격  </th>
      <c:if test="${memberGrade eq 'admin'}">
      <th> 보임여부 </th>
      </c:if>  
      
<c:forEach items="${li}"  var="m" >
 <tr>  
      <td align="center"> ${m.pdId} </td>
      <td><img alt="${m.pdImgstr}" src="${path}/product/files/${m.pdImgstr}" class="pdImg"/></td>
      <c:if test="${m.pdType eq 'monitor'}"><td> 모니터 </td></c:if>
      <c:if test="${m.pdType eq 'keyboard'}"><td> 키보드 </td></c:if>
      <c:if test="${m.pdType eq 'speaker'}"><td> 스피커 </td></c:if>
      <td><a href="${path}/productDetail.do?pdId=${m.pdId}">${m.pdName}</a> </td>
      <td><fmt:formatNumber value="${m.pdPrice}" pattern=",000"/> 원 </td>
      <c:if test="${memberGrade eq 'admin'}">
      <td align="center">${m.pdShow}</td>
      </c:if>
 </tr> 
</c:forEach>
 </table>
 
 <a href=${path}/ReBoardselectAll.do?start=1>처음으로</a> &emsp;
 <c:if test="${m.listStartpage > m.pageListSize }">
  <c:set var="start" value="${(m.listStartpage - m.pageListSize -1) * m.pageSize + 1 }" />
  <a href=${path}/ReBoardselectAll.do?start=${start}>이전${m.pageListSize}페이지</a> &emsp;
 </c:if>
 <c:if test="${m.listStartpage <= m.pageListSize }">
  이전${m.pageListSize}페이지&emsp;
 </c:if>
 
 <c:forEach var="i" begin="${m.listStartpage}" end="${m.listEndPage}" >
  <c:if test="${ i <= m.totalPage }">
	  <c:set var="start" value="${(i-1)*m.pageSize+1}" />
	  [<a href=${path}/ReBoardselectAll.do?start=${start}>${i}</a>]
  </c:if>
 </c:forEach>
 
 <c:if test="${ m.listEndPage < m.totalPage }">
   <c:set var="start"  value="${m.listEndPage * m.pageSize + 1 }" />
   &emsp;<a href=${path}/ReBoardselectAll.do?start=${start}>다음${m.pageListSize}페이지</a> &emsp;
 </c:if>
  <c:if test="${ m.listEndPage >= m.totalPage }">
   &emsp;다음${m.pageListSize}페이지 &emsp;
 </c:if>
 
 <c:set var="start"  value="${m.endPage}"   />
 <a href=${path}/ReBoardselectAll.do?start=${start}>마지막으로 </a>

<form action=memberList.do>
 <select id="pdSearch" name=searchCondition onchange="chageLangSelect()">
  <option value="" selected disabled>--검색 조건--</option>      
  <option value='pdType'> 타입 </option>
  <option value='pdName'> 상품명 </option>
 </select>
 <input id="pdKeyword" type=text  name=searchKeyword>
 <input  type=submit  value="검색하기">
</form> 

</div>
</section>
<c:import url="/include/footer.jsp" />