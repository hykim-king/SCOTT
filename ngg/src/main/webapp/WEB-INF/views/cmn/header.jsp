<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<script type="text/javascript">
</script>
<body>
    
    <div id="logo">
	  <a href="${contextPath}/main/main.do">
		<img width="100" height="100" alt="logo" src="${contextPath}/resources/image/Logo.jpg">
	  </a>
	</div>
	
	<div>
		<ul>
		   <c:choose>
		     <c:when test="${isLogOn==true && !empty memberInfo }">
			   <li><a href="${contextPath}/user/logout.do">로그아웃</a></li>
			   <li><a href="${contextPath}/user/mypage.do">마이페이지</a></li>
			 </c:when>
			 <c:otherwise>
			   <li><a href="${contextPath}/user/login.do">로그인</a></li>
			   <li><a href="${contextPath}/user/register.do">회원가입</a></li> 
			 </c:otherwise>
			</c:choose>
			 
			<li><a href="#">고객센터</a></li>
      		
      		<c:if test="${isLogOn==true and userInfo.userId.equals('admin') }">  
	   	   	  <li><a href="">관리자</a></li>
	    	</c:if>			  
		</ul>
	</div>
	<br>
	
</body>
</html>