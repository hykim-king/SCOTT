<%--
/**
  file name: 
  description:
  user: aprk4
  create date: 2022-01-25
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-01-25 최초생성
 -----------------------------------------------------
 */
--%>
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
    <style type="text/css">
    
		h3{
		text-align: center;
		} 
		ul {
		list-style-type: none;
		}   
    </style>
    <title>신고</title>
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
    	
    	$("#doInsert").on("click",function(e){
    		
		let reportUser = ${sessionScope.user.name } //신고자
		let reportCt   = $("#reportCt").val(); //신고구분
		let reportCnt  = $("#reportCnt").val();//신고내용
	  //let reportCcSq =                      //신고게시글(댓글,게시글)의 고유 번호
	  //let typeSq     =                      //신고게시글(댓글,게시글)의 종류
		console.log(reportCt);
		console.log(reportCnt);
		console.log(reportUser);
		
		if (confirm("신고하시겠습니까?") == false)
			return;
		$.ajax({
 		          type:"POST",
 		          url:"${cp}/report/doInsert.do",
 		          data:{
 		        	 "reportUser":reportUser,
 		        	  "reportCt":reportCt,
 		        	 "reportCnt":reportCnt
 		          } ,
 		          dataType: "json",
 		        	success:function(data){
 		            console.log("data"+data)
 		            alert(data.msgContents)
		    		window.close();
 		          },
 		          error:function(xhr){
 		          console.log(xhr.status+"/"+xhr.errorText);
 		          }
 		      });
    	});//doInsert
    	
    	
    	$("#doCancel").on("click",function(e){
     		
     	if(confirm("신고를 취소 하시겠습니까?")==false)return;
     	window.close();
     		
     	});//doCancel
    	
    });
    </script>
</head>
<body>
	<div class="container">
		<!-- 제목 -->
		<div class="row">
			<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
				<div class="page-header">
					<h2>신고</h2>
				</div>
			</div>
		</div>	
		<!-- 제목 ------------------------------------------------>
		<!-- 신고사유 -->
		<div class="row text-right">
			<form action="#" class="form-inline col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="form-group">
					<h3>신고사유</h3>
					<select class="form-control input-sm" id="reportCt" name="reportCt">
						<option value="0">욕설, 비방, 차별, 혐오</option>
						<option value="1">홍보, 영리목적</option>
						<option value="2">불법 정보</option>
						<option value="3">음란, 청소년 유해</option>
						<option value="4">개인 정보 노출, 유포, 거래</option>
						<option value="5">도배, 스팸</option>
						<option value="6">기타</option>
					</select> 
					<input type="text" class="form-control input-sm" placeholder="신고상세"
						id="reportCnt" name="reportCnt"> 
						
					<input type="button" class="btn btn-default btn-sm" value="신고" id="doInsert">
					<input type="button" class="btn btn-default btn-sm" value="취소" id="doCancel">
				</div>
			</form>
		</div>
		<!-- 신고 사유------------------------------------------------ -->
		
</body>
</html>