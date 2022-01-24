<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
</script>
</head>
<body>
<h1>마이페이지</h1>
	<span>${userInfo.userId}</span> 
	<a href="${contextPath}/user/myInfo.do">수정</a>

	<table>
		<tbody>
			<tr>
				<td>키</td>
				<td>몸무게</td>
				<td></td>
			</tr>
			<tr>
				<td>${userInfo.userHeight}</td>
				<td>${userInfo.userWeight}</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<a href="${contextPath}/user/myInfo.do">수정</a>


//캘린더 구현 - > calendar.html


</body>
</html>
