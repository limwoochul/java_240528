<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<title>성적조회</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container">
		<h1>성적 조회</h1>
		<form class="input-group mb-3" action="<c:url value="/admin/gradelist"/>">
			<div class="input-group-prepend">
				<select class="form-control" name="type">
					<option value="me_id" <c:if test="${pm.cri.type == 'me_id'}">selected</c:if>>학번</option>
					<option value="me_name" <c:if test="${pm.cri.type == 'me_name'}">selected</c:if>>학생 이름</option>
					<option value="su_name" <c:if test="${pm.cri.type == 'su_name'}">selected</c:if>>과목 이름</option>
				</select>
			</div>
			<input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${param.search}">
			<div class="input-group-append">
			    <button class="btn btn-primary" type="submit">검색</button>
			</div>
		</form>
		
		<table class="table">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>연도</th>
					<th>학기</th>
					<th>과목</th>
					<th>학점</th>
					<th>성적</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${list != null}">
					<c:forEach var="grade" items="${list}">
						<tr>
							<td>${grade.me_id}</td>
							<td>${grade.me_name}</td>
							<td>${grade.le_year}</td>
							<td>${grade.le_semester}</td>
							<td>${grade.su_name}</td>
							<td>${grade.su_point}</td>
							<td>${grade.co_grade}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${list == null}">
					<tr>
						<td colspan="7">조회된 성적이 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<c:url var="url" value="/admin/gradelist">
					<c:param name="page" value="${pm.startPage - 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">이전</a>
				</li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:url var="url" value="/admin/gradelist">
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<c:choose>
					<c:when test="${pm.cri.page eq i}">
						<c:set var="active" value="active"/>
					</c:when>
					<c:otherwise>
						<c:set var="active" value=""/>
					</c:otherwise>
				</c:choose>
				<li class="page-item ${active}">
					<a class="page-link" href="${url}">${i}</a>
				</li>
			</c:forEach>
			<c:if test="${pm.next}">
				<c:url var="url" value="/admin/gradelist">
					<c:param name="page" value="${pm.endPage + 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">다음</a>
				</li>
			</c:if>
		</ul>
	</div>

</body>
</html>