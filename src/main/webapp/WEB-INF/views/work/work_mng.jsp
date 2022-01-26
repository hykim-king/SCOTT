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
    
    <title>로그인</title>
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
			
			
			$("#doUpdate")on("click",function(e){
				let url = "${cp}/work/doUpdate.do";
				let workSq = $("#workSq").val();

				let workTilte = $("#workTitle").val();
				let workContent = $("#workContent").val();
				
				if(eUtil.ISEpmty(workTilte)){
					alert("제목을 입력하세요");
					$("#workTitle").focus();
				}
				if(eUtil.ISEpmty(workContent)){
					alert("내용을 입력하세요");
					$("#workContent").focus();
				}
				
				let parameter = {
						"workTilte":workTilte ,
						"workSq": workSq,
						"workContent":workContent
				};
				let method = "POST"
				let async  = true;
				if (confirm("수정하시겠습니까?") == false)
					return;
				
				EClass.callAjax(url, parameters, method,async, function(data) {
							console.log("msgId: "
									+ data.msgId);
							console.log("msgContents: "
									+ data.msgContents);

							if ("1" == data.msgId) {
								alert(data.msgContents);
								moveToList();
							} else {
								alert(data.msgContents);
							}

						});//callback
			});
			
			
			$("#doDelete").on("click",function(e){
				let workSq = $("#workSq").val();
				
				if(eUtil.ISEmpty(workSq)==true){
					alert("게시순번을 확인하세요")
					return;
				}
				
				if(confirm("삭제하시겠습니까?")==false)return;
				
				let url = "${cp}/work/doDelete.do";
				let parameter = {
						"workSq":workSq
				};
				let method = "GET"
				let async  = true;
				
				EClass.callAjax(url, parameters, method,async, function(data) {
					console.log("msgId: "+ data.msgId);
					console.log("msgContents: "+ data.msgContents);
			 });
			});	
			
			$("#doInsert").on("click",function(e){
				let url = "${cp}/work/doInsert.do";
				
				let workTilte = $("#workTitle").val();
				let workContent = $("#workContent").val();
				
				if(eUtil.ISEpmty(workTilte)){
					alert("제목을 입력하세요");
					$("#workTitle").focus();
				}
				if(eUtil.ISEpmty(workContent)){
					alert("내용을 입력하세요");
					$("#workContent").focus();
				}
				
				let parameter = {
						"workTilte":workTilte ,
						"workContent":workContent
				};
				let method = "POST"
				let async  = true;
				if (confirm("등록하시겠습니까?") == false)
					return;
				
				EClass.callAjax(url, parameters, method,async, function(data) {
							console.log("msgId: "
									+ data.msgId);
							console.log("msgContents: "
									+ data.msgContents);

							if ("1" == data.msgId) {
								alert(data.msgContents);
								moveToList();
							} else {
								alert(data.msgContents);
							}

						});//callback 
			});
			
			function moveToList(){
		    	window.location.href="${cp}/work/work_view.do";

			}
			$("#moveToList").on("click",function(e){
				if (confirm("목록으로 이동하시겠습니까?") == false)
					return;
				moveToList();
			});
	
	
	});
</script>
</head>
<body>
	<div class="container">
		<!-- 제목 -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="page-header">
					<h2>NoGymGood MNG Test</h2>
				</div>
			</div>
		</div>
		<!-- //제목 --------------------------------------------------------------------------->

		<!-- 버튼 -->
		<div class="row text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<input type="button" class="btn btn-default btn-sm btn-primary" value="수정"  id="doUpdate">
			<input type="button" class="btn btn-default btn-sm btn-primary" value="삭제"  id="doDelete">
			<input type="button" class="btn btn-default btn-sm btn-primary" value="목록"  id="moveToList">
		</div>
		<!-- 버튼 ----------------------------------------------------------------------------->


		<!-- 등록 -->
		<div class="row col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form action="#" class="form-horizontal"> 
				<div class="form-group">
					<label for="workTitle" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" maxlength="50" class="form-control" id="workTitle"
							name="workTitle" placeholder="제목">
					</div>
				</div>
				<div class="form-group">
					<label for="workTitle" class="col-sm-2 control-label">게시번호</label>
					<div class="col-sm-10"><c:out value="${vo.workSq} "/>
						<input type="hidden" maxlength="50" class="form-control" id="workSq"
							name="workSq">
					</div>
				</div>
				<div class="form-group">
					<label for="passwd" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
						<textarea rows="10" cols="20" name="workContent" class="form-control"></textarea>
					</div>
				</div>
			</form>
		</div>
		<!-- //등록--------------------------------------------------------------------------->
  </div>
</body>
</html>