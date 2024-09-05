<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="navbar-brand p-0" href="#">
					<img src="<c:url value="/resources/img/dog.jpg"/>" alt="logo" style="width:40px;">
				</a>					
			</li>			
			<li class="nav-item">
				<a class="nav-link" href="#">Link 1</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link 2</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link 3</a>
			</li>
		</ul>
		<ul class="navbar-nav">
			<c:if test="${user eq null}">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/guest/signup"/>">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/guest/login"/>">로그인</a>
				</li>
			</c:if>
			<li class="nav-item">
				<a class="nav-link" href="#">Link 3</a>
			</li>
		</ul>
	</nav>	
</body>
</html>
