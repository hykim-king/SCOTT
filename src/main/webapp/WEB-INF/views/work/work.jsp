<%--
/**
  file name: 
  description:
  user: aprk4
  create date: 2022-01-21
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-01-21 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp_res"
	value="${pageContext.request.contextPath}/resources/assets" />
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
    	
    	
    	renderingPage('${totalPage}',10);
    	
    	function renderingPage(pageTotal,page){
            console.log("renderingPage:"+ pageTotal)  ; 
            
            pageTotal = parseInt(pageTotal);
            console.log("pageTotal:"+ pageTotal)  ; 
            //이전 연결된 EventHandler제거 
            $('#page-selection').unbind('page');
    		
            $('#page-selection').bootpag({
                total: pageTotal,
                page: page,
                maxVisible: 10,
                leaps: true,
                firstLastUse: true,
                first: '←',
                last: '→',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next',
                prevClass: 'prev',
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function(event, num){
                console.log("num:"+num);
                doRetrieve(num)
            });                
       }
    	
    	
     	$("#work_table>tbody").on("click","tr",function(e){
     		let tds = $(this).children();
     		let workSq = tds.eq(5).text();
     		
     		window.location.href="${cp}/work/doSelectOne?workSq="+workSq;
     	});
    	
    	
    	//등록
    	$("#moveToReg").on("click",function(e){
    		console.log("moveToReg")
    		window.location.href="${cp}/work/moveToReg.do";
    	});
    	
    	//검색버튼
    	$("#doRetrieve").on("click",function(e){
    		doRetrieve(1)
    	});
    	
    	//신고버튼
		$("#doReport").on("click",function(e){
			
			window.open("${cp}/report/doReport.do","report","width=400, height=300,left=100,top=50");
			//window.location.href="${cp}/report/doReport.do";
		});    	
    	
    	function doRetrieve(page) {

			let url = "${cp}/work/doRetrieve.do";
			let parameters = {
				pageSize : $("#pageSize").val(),
				pageNum : page,
				searchDiv : $("#searchDiv").val(),
				searchWord : $("#searchWord").val()
			};
			let method = "GET";
			let async = true;
    	
    	EClass.callAjax(url,parameters,	method,	async,function(data) {
    		
    		let parsedData = data;
			//1 기존데이터 삭제
			$("#work_table>tbody").empty();
			
			//2 신규데이터 출력
			console.log("data: "+ parsedData.length);
			let html = "";
			let totalCount = 0;
		    let pageTotal = 1;
		if (parsedData.length > 0) {
			totalCount = parsedData[0].totalCnt;

			pageTotal = (totalCount / $("#pageSize").val());
			pageTotal = Math.ceil(pageTotal);

			$.each(parsedData,function(i,vo) {
				console.log("i: "+ value.name);
				html += " <tr>  ";
				html += "	<td class='text-center'>"+ vo.num+ "</td>   ";
				html += "	<td class='text-left'>"+ vo.workTitle+ "</td>   ";
				html += "	<td class='text-left'>"+ vo.workRegDt+ "</td>   ";
				html += "	<td class='text-right'>"+ vo.workReadCn+ "</td>  ";
				html += "	<td style='display:none;'>"+ vo.workSq+ "</td>  ";
				html += "</tr>                                          ";
			});
			} else {
				html += "<tr>                                         ";
				html += "	<td colspan='99' class='text-center'>NO DATA FOUND</td>  ";
				html += "</tr>                                        ";
				}
			//테이블 데이터
			$("#work_table>tbody").append(htpm);
			//paging 기존 데이터 삭제
			$("#page-selection").empty();
			
			
    	});//Function doRetrive
    };
    });
    </script>
</head>
<body>
	<div class="container">
		<!-- 제목 -->
		<div class="row">
			<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
				<div class="page-header">
					<h2>NoGymGood Test</h2>
				</div>
			</div>
		</div>
		<!-- 제목 ------------------------------------------------>
		<!-- 검색 -->
		<div class="row text-right">
			<form action="#"
				class="form-inline col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="form-group">
					<select class="form-control input-sm" id="searchDiv"
						name="searchDiv">
						<option value="">전체</option>
						<option value="10">제목</option>
						<option value="20">내용</option>
					</select> <input type="text" class="form-control input-sm" placeholder="검색어"
						id="searchWord" name="searchWord"> <select
						class="form-control input-sm" id="pageSize" name="pageSize">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="200">200</option>
					</select> <input type="button" class="btn btn-default btn-sm" value="검색"
						id="doRetrive"> <input type="button"
						class="btn btn-default btn-sm" value="등록" id="moveToReg">
					<input type="button" class="btn btn-default btn-sm" value="신고"
						id="doReport">
				</div>
			</form>
		</div>

		<!-- 검색 ------------------------------------------------>

		<!-- 목록 -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<table id="work_table" class="table table-bordered table-striped">
					<thead>
						<tr class="bg-primary">
							<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">번호</th>
							<th class="text-center col-xs-2 col-sm-2 col-md-2 col-lg-2">제목</th>
							<th class="text-center col-xs-2 col-sm-2 col-md-2 col-lg-2">등록일</th>
							<th class="text-center col-xs-2 col-sm-2 col-md-2 col-lg-2">조회수</th>
							<th style="display: none">workSq</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list.size()>0}">
								<c:forEach var="vo" items="${list}">
									<tr>
										<td class="text-center"><c:out value="${vo.num }" /></td>
										<td class="text-left"><c:out value="${vo.workTitle }" /></td>
										<td class="text-left"><c:out value="${vo.workRegDt }" /></td>
										<td class="text-right"><c:out value="${vo.workReadCnt }" /></td>
										<td style="display: none"><c:out value="${vo.workSq }" /></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan='99' class="text-center">NO DATA FOUND</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 제목 ------------------------------------------------>

		<!-- 제목 -->
		<!-- 제목 ------------------------------------------------>

		<!-- 제목 -->
		<!-- 제목 ------------------------------------------------>

		<!-- 제목 -->
		<!-- 제목 ------------------------------------------------>

		<!-- 제목 -->
		<!-- 제목 ------------------------------------------------>
		<div class="text-center col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div id="page-selection" class="text-center page"></div>
		</div>

	</div>
	<!-- contatiner -------------------------------- -->

</body>
</html>