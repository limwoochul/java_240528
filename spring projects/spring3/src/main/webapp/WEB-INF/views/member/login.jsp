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
