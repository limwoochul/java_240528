<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cg.cg_name} 상품</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>${cg.cg_name} 상품 목록</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>상품이름</th>
				<th>가격</th>
				<th>재고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="pr">
				<tr>
					<td>${pr.pr_name}</td>
					<td>${pr.pr_price}원</td>
					<td>${pr.pr_inventory}개</td>				
				</tr>
			</c:forEach>
			<c:if test="${list.size() == 0}">
				<tr>
					<th colspan="3" class="text-center">등록된 상품이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<c:url var="url" value="/shoppingmall/list">
					<c:param name="cg_num" value="${pm.cri.cg_num}"/>
					<c:param name="page" value="${pm.startPage-1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<a class="page-link" href="${url}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
			<c:choose>
				<c:when test="${pm.cri.page == i}">
					<c:set var="active" value="active"/>
				</c:when>
				<c:otherwise>
					<c:set var="active" value=""/>
				</c:otherwise>
			</c:choose>
			<li class="page-item ${active}">
				<c:url var="url" value="/shoppingmall/list">
					<c:param name="cg_num" value="${pm.cri.cg_num}"/>
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<c:url var="url" value="/shoppingmall/list">
					<c:param name="cg_num" value="${pm.cri.cg_num}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<a class="page-link" href="${url}">다음</a>
			</li>
		</c:if>
	</ul>
</div>
</body>
</html>