<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>쇼핑몰 목록</h1>
	<ul class="list-community">
		<div class="btn-group-vertical">
			<a href="/shoppingmall/searchproductall" class="btn btn-primary">상품 전체조회</a>
			<a type="/shoppingmall/searchproductname" class="btn btn-primary">상품 이름으로 검색</a>
			<a type="/shoppingmall/mypage" class="btn btn-primary">마이페이지</a>
		</div>
	</ul>
</div>
</body>
</html>