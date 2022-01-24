<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script>
	function IdCheck() {
		var id = $("#userId").val();
		if (id == '') {
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/user/overlapped.do",
			dataType : "text",
			data : {
				userId : userId
			},
			success : function(data, textStatus) {
				if (data == 'false') {
					alert("사용할 수 있는 ID입니다.");
					$('#btnOverlapped').prop("disabled", true);
					$('#userId').prop("disabled", true);
					$('#_userId').val(id);
				} else {
					alert("사용할 수 없는 ID입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
			},
			complete : function(data, textStatus) {
				alert("작업을 완료했습니다");
			}
		})
	}
	
	function NnCheck() {
		var nn = $("#userNn").val();
		if (nn == '') {
			alert("닉네임을 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/user/overlapped02.do",
			dataType : "text",
			data : {
				userNn : nn
			},
			success : function(data, textStatus) {
				if (data == 'false') {
					alert("사용할 수 있는 닉네임입니다.");
					$('#btnOverlapped02').prop("disabled", true);
					$('#userNn').prop("disabled", true);
					$('#_userNn').val(nn);
				} else {
					alert("사용할 수 없는 닉네임입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
			},
			complete : function(data, textStatus) {
				alert("작업을 완료했습니다");
			}
		})
	}
		
	function PwCheck() {
		 var pw = $("#pw").val();
		 var _pw = $("#_pw").val();
		  if(document.getElementById('pw').value!='' && document.getElementById('_pw').value!='') {
		      if(document.getElementById('pw').value==document.getElementById('_pw').value) {
	            document.getElementById('pwCheckMsg').innerHTML='비밀번호가 일치합니다.';
  	            document.getElementById('pwCheckMsg').style.color='blue';
		      }
              else {
                document.getElementById('pwCheckMsg').innerHTML='비밀번호가 일치하지 않습니다.';
	            document.getElementById('pwCheckMsg').style.color='red';
	          }
		   }
	}
	
	function PwValidate(){
		 var pw = $("#pw").val();
		 var _pw = $("#_pw").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 if(pw.length < 8 || pw.length > 20){

		  alert("8자리 ~ 20자리 이내로 입력해주세요.");
		  return false;
		 }else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		 }else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		  return false;
		 }else {
			console.log("통과"); 
		    return true;
		 }
	}
	
</script>
</head>
<body>
	<h3>회원가입</h3>
	<form action="${contextPath}/user/register.do" method="post">
		<div>
			<table>
				<tbody>

					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="userId" id="userId" />
							<input type="hidden" name="_userId" id="_userId" />
							<input type="button" id="btnOverlapped" value="중복체크" onClick="IdCheck()" />
						</td>
					</tr>

					<tr>
						<td>비밀번호</td>
						<td>
							<input id="pw" name="userPw" type="password" onchange="PwCheck(), PwValidate()" /> &nbsp;&nbsp;
							<span id="pwValMsg"></span>
						</td>	
					</tr>
					
					<tr>
						<td>비밀번호 확인</td>
						<td>
							<input id="_pw" name="_userPw" type="password" onchange="PwCheck()" /> &nbsp;&nbsp;
							<span id="pwCheckMsg"></span>
						</td>
					</tr>
	
					<tr>
						<td>닉네임</td>
						<td>
							<input type="text" name="userNn" id="userNn" />
							<input type="hidden" name="_userNn" id="_userNn" />
							<input type="button" id="btnOverlapped02" value="중복체크" onClick="NnCheck()" />
						</td>
					</tr>
					
	
					<tr>
						<td>이메일<br>(e-mail)</td>
						<td>
							<input type="text" name="email" /> @ 
							<input type="text" name="domain" /> 
							<select name="domain" onChange="" title="직접입력">
								<option value="non">직접입력</option>
								<option value="gmail.com">gmail.com</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="google.com">google.com</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="nate.com">nate.com</option>
								<option value="hotmail.com">hotmail.com</option>
							</select>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="clear">
			<input type="submit" value="회원 가입"> 
			<input type="reset" value="다시입력">
		</div>
	</form>
</body>
</html>