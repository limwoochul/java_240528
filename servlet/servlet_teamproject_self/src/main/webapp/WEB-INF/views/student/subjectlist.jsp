<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/common/head.jsp"/>

<title>커뮤니티</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container-fluid py-3" style="min-height: calc(100vh - 112px);">
	<h1 class="mb-3">과목 목록</h1>
	
	<table class="table table-hover">
		<colgroup>
			<col style="width: 7%;">
			<col style="width: auto;">
			<col style="width: 10%;">
			<col style="width: 10%;">
			<col style="width: 15%;">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">과목명</th>
				<th scope="col">시수</th>
				<th scope="col">학점</th>
				<th scope="col">전공여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${subjectList}" var="suList">
				<tr>
					<td>${suList.su_num}</td>
					<td>${suList.su_name}</td>
					<td>${suList.su_time}시간</td>
					<td>${suList.su_point}학점</td>
					<td>${suList.su_status}</td>
				</tr>
			</c:forEach>
			<c:if test="${subjectList.size() == 0}">
				<tr>
					<th colspan="5" class="text-center">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	 </table>

	<div class="ft_info_wrap d-flex justify-content-between">
		<div class="ft_info_left_wrap">
			<a href="#" class="btn btn-outline-dark">목록</a>
		</div>
		<c:if test="${pm.endPage ne 0}">
			<ul class="pagination justify-content-center mb-0">
				<c:if test="${!pm.prev}">
					<c:set var="prev" value="disabled"/>
				</c:if>
				<c:url var="url" value="/subject/subjectList">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${pm.startPage - 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<li class="page-item ${prev}">
					<a class="page-link" href="${url}">이전</a>
				</li>
				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
					<c:if test="${pm.cri.page == i}">
						<c:set var="active" value="active"/>
					</c:if>
					<c:if test="${pm.cri.page != i}">
						<c:set var="active" value=""/>
					</c:if>
					<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
						<c:param name="page" value="${i}"/>
						<c:param name="type" value="${pm.cri.type}"/>
						<c:param name="search" value="${pm.cri.search}"/>
					</c:url>
					<li class="page-item ${active}">
						<a class="page-link" href="${url}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${!pm.next}">
					<c:set var="next" value="disabled"/>
				</c:if>
				<c:url var="url" value="/subject/subjectList">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${pm.endPage + 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<li class="page-item ${next}">
					<a class="page-link" href="${url}">다음</a>
				</li>
			</ul>
		</c:if>
		<div class="ft_info_right_wrap">
			<a href="<c:url value="/post/insert?co_num=${co.co_num}"/>" class="btn btn-outline-primary">게시글 등록</a>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>