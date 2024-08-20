<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 이름검색</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>상품 이름으로 검색</h1>
	<form class="input-group mb-3" action="<c:url value="/shoppingmall/list"/>">
		<input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-primary" type="submit">검색</button>
		</div>
		<input type="hidden" name="co_num" value="${pm.cri.co_num}">
	</form>
</div>
</body>
</html>