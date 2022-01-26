<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="cp_res" value="${pageContext.request.contextPath}/resources/assets" />
<c:set var="cp" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    
    <title></title>
     <!-- 부트스트랩 -->
    <link href="${cp_res}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script type="text/javascript" src="${cp_res}/js/jquery-3.6.0.min.js"></script>
    <!-- ajax 통신 -->
    <script type="text/javascript" src="${cp_res}/js/eclass.js"></script>
    <script type="text/javascript" src="${cp_res}/js/eUtil.js"></script>
       
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${cp_res}/js/bootstrap.min.js"></script>
    <script src="${cp_res}/js/jquery.bootpag.js"></script>
    
    <script type="text/javascript">
    $(document).ready(function(){
    	
    });
    </script>
</head>
<body>
	<c:out value="${vo.workTitle }"></c:out>
</body>
</html>