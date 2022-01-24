<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:if test='${not empty message }'>
	<script>
		window.onload = function() {
			result();
		}

		function result() {
			alert("아이디 또는 비밀번호가 틀립니다. 다시 로그인해주세요");
		}
	</script>
</c:if>
</head>
<body>
	<h3>로그인</h3>
	<div>
		<form action="${contextPath}/user/login.do" method="post">
			<table>
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input name="userId" type="text" /></TD>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input name="userPw" type="password" /></TD>
					</tr>
				</tbody>
			</table>
			
			<br> <br> 
			<input type="submit" value="로그인"> 
			<input type="reset" value="초기화"> 
			<br> <br> 
			<a href="#">아이디 찾기</a>  
			<a href="#">비밀번호 찾기</a>  
			<a href="${contextPath}/user/register.do">회원가입</a>  
			<a href="#">고객센터</a>
		</form>
	</div>
</body>
</html>