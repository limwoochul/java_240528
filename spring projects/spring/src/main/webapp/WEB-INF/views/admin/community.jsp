<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1 class="mt-3">커뮤니티 관리</h1>
<ul class="list-group mt-3 mb-3">
	<c:forEach items="${list}" var="community">
		<li class="list-group-item d-flex justify-content-between align-items-center">
			<span class="community-name">${community.co_name}</span>
			<span>
				<span class="badge badge-primary badge-pill">${community.co_count}</span>
				<button class="btn-co-update btn btn-outline-danger" data-num="${community.co_num}">수정</button>
				<a class="btn btn-outline-dark" href="<c:url value="/admin/community/delete?co_num=${community.co_num}"/>">삭제</a>
			</span>
		</li>
	</c:forEach>
</ul>
<form action="<c:url value="/admin/community/insert"/>" method="post" id="form1">
	<div class="input-group mb-3">
		<input type="text" class="form-control" placeholder="등록할 커뮤니티명을 입력하세요." 
				name="name" required>
		<div class="input-group-append">
			<button type="submit" class="btn btn-outline-info col-12">등록</button>
		</div>
	</div>	
</form>
<script type="text/javascript">
	$('.btn-co-update').click(function(){
		$('#form2').remove();
		var co_num = $(this).data('num');
		var co_name = $(this).parent().prev().text();
		var str = '';
		str += `
			<form action="<c:url value="/admin/community/update"/>" method="post" id="form2">
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="수정할 커뮤니티명을 입력하세요." 
							name="co_name" required value="\${co_name}">
					<div class="input-group-append">
						<button type="submit" class="btn btn-outline-info col-12 btn-update">수정완료</button>
					</div>
					<input type="hidden" name="co_num" value="\${co_num}">
				</div>	
			</form>
		`;
		
		$('#form1').hide().after(str);
	});
</script>

<!-- 
community.jsp
1. 삭제 버튼을 a태그로 수정
  - href에 삭제할 커뮤니티 번호를 추가

컨트롤러
1. 메소드를 추가
  - GetMapping 추가
  - 매개변수로 커뮤니티 번호를 받아옴
  - 서비스에게 커뮤니티 번호를 주면서 삭제하라고 요청
  - 삭제 여부를 알림으로 출력


community.jsp
1. 수정 버튼에 data-xxx을 추가해서 커뮤니티 번호를 추가
2. 수정(커뮤니티리스트 옆) 버튼 클릭이벤트를 등록
  - 커뮤니티 번호를 가져옴
  - 현재 선택한 커뮤니티의 커뮤니티 이름을 가져옴
  - 커뮤니티 번호와 커뮤니티 이름을 이용해서 문자열로 된 html 코드를 구성
    => 현재 커뮤니티 이름이 들어간 input태그를 포함한 html 코드
  - 기존에 있는 커뮤니티 등록 화면을 감춤
  - 기존에 있는 커뮤니티 등록 화면 뒤에 위에서 만든 html코드를 추가
3. 수정(커뮤니티 수정창 옆) 버튼 클릭 이벤트 등록
  - 커뮤니티 번호를 가져옴
  - 커뮤니티 이름을 가져옴
  - 서버에 전송해서 수정을 요청
  - 성공 여부에 따라 알림을 출력
컨트롤러
1. 화면에서 보낸 커뮤니티 번호, 이름을 가져옴
2. 서비스에게 커뮤니티 번호, 이름을 주면서 수정하라고 요청
4. 수정여부를 화면에 전달

 -->
</body>
</html>
