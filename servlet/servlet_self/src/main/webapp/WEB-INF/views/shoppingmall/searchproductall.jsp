<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체상품조회</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<style type="text/css">
.list-community{
	list-style: none; display: flex; flex-wrap: wrap;	
}
.item-community{
	width: 33.33%; height: 80px; box-sizing: border-box; padding: 10px;
}
.link-community{
	display: block; border: 1px solid black; box-sizing: border-box;
	height: 100%; text-align: center; line-height: 58px; font-size:24px;
	text-decoration: none; color: black;
}
.link-community:hover{
	text-decoration: none; color: white; background-color: tomato;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>카테고리 목록</h1>
	<ul class="list-shopping">
		<c:forEach items="${list}" var="sp">
			<li class="item-shopping">
				<c:url var="url" value="/shoppingmall/list">
					<c:param name="cg_num" value="${sp.cg_num}"></c:param>
				</c:url>
				<a href="${url}" class="link-shopping">${sp.cg_name}</a>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>