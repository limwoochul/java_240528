<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value="/guest/login"/>" method="post" id="form">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="me_id" name="me_id" value="${id}">
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="me_pw" name="me_pw">
		</div>
		<button type="submit" class="btn btn-outline-info col-12">로그인</button>
	</form>
	<hr>
	<!-- 클릭 시 loginWithKakao() 함수 호출 -->
	<a id="kakao-login-btn" href="javascript:loginWithKakao()">
	  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
	    alt="카카오 로그인 버튼" />
	</a>
	
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	
	<script type="text/javascript">
		Kakao.init('6dca89fec7bf9a3fb3016dba8f4e45df'); // 사용하려는 앱의 JavaScript 키 입력
		function loginWithKakao() {
			Kakao.Auth.login({
	      success: function (authObj) {
	         Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
						
	         getInfo();
	      },
	      fail: function (err) {
	          console.log(err);
	      }
	    });
	  }
		function getInfo() {
	    Kakao.API.request({
	      url: '/v2/user/me',
	      success: function (res) {
	        // 이메일, 성별, 닉네임, 프로필이미지
	        var id = res.id;
	        var email = res.kakao_account.email;
	        var sns = "kakao";
	        if(!checkMember(sns, id)){
	        	if(confirm("회원이 아닙니다. 가입하시겠습니까?")){
	        		signupSns(sns, id, email);
	        	}else{
	        		return;
	        	}
	        }
	        snsLogin(sns, id);
	       	location.href = '<c:url value="/"/>';

	      },
	      fail: function (error) {
	          alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
	      }
	    });
	  }
	  function checkMember(sns, id){
		  var res;
		  $.ajax({
				async : false,
				url : `<c:url value="/sns"/>/\${sns}/check/id`, 
				type : 'post', 
				data : {id}, 
				success : function (data){
					res = data;
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		  return res;
	  }
	  function signupSns(sns, id, email){
		  $.ajax({
				async : false,
				url : `<c:url value="/sns"/>/\${sns}/signup`, 
				type : 'post', 
				data : {id, email}, 
				success : function (data){
					
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					
				}
			});
	  }
	  function snsLogin(sns, id){
		  $.ajax({
				async : false,
				url : `<c:url value="/sns"/>/\${sns}/login`, 
				type : 'post', 
				data : {id}, 
				success : function (data){
					if(data){
						alert("로그인 되었습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					
				}
			});
	  }
	</script>
	
	<script type="text/javascript">
	var id = $('#me_id').val();
	if(id == ''){
		$('#me_id').focus();
	} else{
		$('#me_pw').focus();
	}
	
	//아이디나 비번이 입력되지 않으면 알림을 띄우고 해당 창을 활성화
	$('#form').submit(function(){
		var id = $('#me_id').val();
		var pw = $('#me_pw').val();
		if(id == ''){
			alert('아이디를 입력하세요.');
			$('#me_id').focus();
			return false;
		}
		if(pw == ''){
			alert('비번을 입력하세요.');
			$('#me_pw').focus();
			return false;
		}
		return true;
	})
	</script>
</body>
</html>
