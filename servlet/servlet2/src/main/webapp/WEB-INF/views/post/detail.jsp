<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">
	<h1 class="mt-3 mb-3">게시글 상세</h1>
	<c:if test="${post != null}">
		<div class="form-group">
			<label>제목 : </label>
			<div class="form-control">${po.po_title}</div>
		</div>
		<div class="form-group">
			<label>작성자 : </label>
			<div class="form-control">${po.po_me_id}</div>
		</div>
		<div class="form-group">
			<label>작성일 : </label>
			<div class="form-control"><fmt:formatDate value="${po.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
		</div>
		<div class="form-group">
			<label>조회수</label>
			<div class="form-control">${po.po_view}</div>
		</div>
		<div class="form-group">
			<label>내용</label>
			<div class="form-control" style="min-height: 400px; height: auto">${po.po_content}</div>
		</div>
		<a href="<c:url value="/post/list?co_num=${po.po_co_num}"/>" class="btn btn-outline-primary">목록</a>
		<c:if test="${user.me_id == po.po_me_id}">
			<a href="<c:url value="/post/update?po_num=${po.po_num}"/>" class="btn btn-outline-dark">수정</a>
			<a href="<c:url value="/post/delete?po_num=${po.po_num}"/>" class="btn btn-outline-danger">삭제</a>		
		</c:if>
	</c:if>
	<c:if test="${post == null }">
		<h3>삭제되거나 등록되지 않은 게시글입니다.</h3>
	</c:if>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>