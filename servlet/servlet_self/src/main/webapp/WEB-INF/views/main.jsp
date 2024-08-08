<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<br>
	<a href="<%=request.getContextPath()%>/signup">회원가입</a>
	<br>
	<a href="<%=request.getContextPath()%>/login">로그인</a>
	<br>
	<a href="<%=request.getContextPath()%>/findpw">비밀번호찾기</a>
</body>
</html>