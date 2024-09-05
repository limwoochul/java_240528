<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1 class="mt-3 mb-3">게시글 상세</h1>
	<div class="form-group">
		<label>제목:</label>
		<div class="form-control">${post.po_title}</div>
	</div>
	<div class="form-group">
		<label>작성자:</label>
		<div class="form-control">${post.po_me_id}</div>
	</div>
	<div class="form-group">
		<label>작성일:</label>
		<div class="form-control">
		<fmt:formatDate value="${post.po_date}" pattern="yyyy.MM.dd."/>
		</div>
	</div>
	<div class="form-group">
		<label>조회수:</label>
		<div class="form-control">${post.po_view}</div>
	</div>
	<div class="form-group">
		<label>내용:</label>
		<div class="form-control" style="min-height:300px; height:auto">${post.po_content}</div>
	</div>
	<a href="<c:url value="/post/list/${post.po_co_num}"/>" class="btn btn-outline-info">목록</a>
</body>
</html>
