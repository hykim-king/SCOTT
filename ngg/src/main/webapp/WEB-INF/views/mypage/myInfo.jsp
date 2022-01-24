<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
 <script>


function modUserInfo(attribute){
	var value;
	var frm = document.frmModUserInfo;
		if(attribute=='userPw'){
			value = frm.userPw.value;
		}else if(attribute=='userNn'){
			value = frm.userPw.value;
		}else if(attribute=='userEmail'){
			var email1=frm.email1;
			var email2=frm.email2			
			emailVal1=email1.value;
			emailVal2=email2.value;
			value=emailVal1+","emailVal2;
		}else if(attribute=='userHeight'){
			value = frm.userHeight.value;
		}else if(attribute=='userWeight'){
			value = frm.userWeight.value;
		}else if(attribute=='userGoal'){
			value = frm.userGoal.value;
		}
		console.log(attribute);
	 
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/mypage/modifyMyInfo.do",
			data : {
				attribute:attribute,
				value:value,
			},
			success : function(data, textStatus) {
				if(data.trim()=='mod_success'){
					alert("회원 정보를 수정했습니다.");
				}else if(data.trim()=='failed'){
					alert("다시 시도해 주세요.");	
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
			}
		}); 
}
</script>
</head>

<body>
	<h3>내 상세 정보</h3>
<form id="frmModUserInfo">	
	<div>
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						<input name="userId" type="text" value="${userInfo.userId}"  disabled/>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					  <input name="userPw" type="password" value="${userInfo.userPw }" />
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userPw')" />
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
					  <input name="userNn" type="text" value="${userInfo.userNn}" />
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userNn')" />
					</td>
				</tr>
				
				<tr>
					<td>이메일</td>
					<td>
					   <input type="text" name="email1" size=10 value="${userInfo.email1 }" /> @ 
					   <input type="text" name="email2" value="${userInfo.email2 }" /> 
					   <select name="select_email2" onChange=""  title="직접입력">
							<option value="non">직접입력</option>
							<option value="gmail.com">gmail.com</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="google.com">google.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
						</select> 
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
					  <input name="userNn" type="text" value="${userInfo.userNn}" />
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userNn')" />
					</td>
				</tr>
				<tr>
					<td>키</td>
					<td>
					  <input name="userHeight" type="text" value="${userInfo.userHeight}" />
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userHeight')" />
					</td>
				</tr>
				<tr>
					<td>몸무게</td>
					<td>
					  <input name="userWeight" type="text" value="${userInfo.userWeight}" />
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userWeight')" />
					</td>
				</tr>
				<tr>
					<td>운동목적</td>
					<td>
						<select name="userGoal" title="${userInfo.userGoal}">
							<option value=0>체중조절</option>
							<option value=1>스트렝스</option>
							<option value=2>근비대</option>
							<option value=3>홈트레이닝</option>
						</select> 
					</td>
					<td>
					  <input type="button" value="수정하기" onClick="modUserInfo('userGoal')" />
					</td>
				</tr>
				<tr>
					<td>등급</td>
					<td>
					  <input name="userGrade" type="text" value="${userInfo.userGrade}" disabled/>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div class="clear">
		<br><br>
		<table>
		<tr>
			<td >
				<input type="hidden" name="command"  value="modifyInfo" /> 
				<input name="btnCancel" type="button"  value="수정 취소">
			</td>
		</tr>
	</table>
	</div>
</form>	
</body>
</html>
