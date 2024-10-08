<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<title>수강생 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container">
	<h1>${su_name} 수강생 목록</h1>
	<table class="table">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학점</th>
				<th>이메일</th>
				<th>성적수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${list}">
				<tr>
					<td>${course.co_me_id}</td>
					<td>${course.member.me_name}</td>
					<c:if test="${course.co_grade != null}">
						<td>${course.co_grade}</td>
					</c:if>
					<c:if test="${course.co_grade == null}">
						<td>N/A</td>
					</c:if>
					<td>${course.member.me_email}</td>
					<td>
						<form action="<c:url value='/professor/updategrade'/>" method="post">
							<input type="hidden" name="co_num" value="${course.co_num}">
							<input type="hidden" name="le_num" value="${course.co_le_num}">
							<input type="hidden" name="su_name" value="${su_name}">
							<select name="co_grade">
								<option value="A+" <c:if test="${course.co_grade == 'A+'}">selected</c:if>>A+</option>
								<option value="A" <c:if test="${course.co_grade == 'A'}">selected</c:if>>A</option>
								<option value="B+" <c:if test="${course.co_grade == 'B+'}">selected</c:if>>B+</option>
								<option value="B" <c:if test="${course.co_grade == 'B'}">selected</c:if>>B</option>
								<option value="C+" <c:if test="${course.co_grade == 'C+'}">selected</c:if>>C+</option>
								<option value="C" <c:if test="${course.co_grade == 'C'}">selected</c:if>>C</option>
								<option value="D+" <c:if test="${course.co_grade == 'D+'}">selected</c:if>>D+</option>
								<option value="D" <c:if test="${course.co_grade == 'D'}">selected</c:if>>D</option>
								<option value="F" <c:if test="${course.co_grade == 'F'}">selected</c:if>>F</option>
							</select>
							<c:if test="${course.co_grade != null}">
								<button type="submit" class="btn btn-danger">수정</button>
							</c:if>
							<c:if test="${course.co_grade == null}">
								<button type="submit" class="btn btn-success">입력</button>
							</c:if>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>