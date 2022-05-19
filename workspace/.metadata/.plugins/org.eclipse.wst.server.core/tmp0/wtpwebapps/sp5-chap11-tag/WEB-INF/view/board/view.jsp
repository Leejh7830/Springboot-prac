<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Gugi&family=Sunflower:wght@700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
* {
	font-family: 'Sunflower', sans-serif;;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
<title>view</title>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="container">
		<div
			style="position: relative; background-color: #eee; margin-top: 1rem">
			<h1>view.jsp</h1>
		</div>
		<div class="mb-3">
			<label class="form-label" for="title">글제목</label> 
			<div style="border:1px solid #ccc; padding:0.8rem; width:80%">${board.title}</div> 
			<label class="form-label" for="content">글내용</label> 
			<div style="border:1px solid #ccc; height:10rem; overflow-y:scroll;  padding:1rem;">
				${board.content}
			</div>
		</div>
		<div class="mb-3 d-flex justify-content-end">
			<a href="update?id=${board.id}" class="btn btn-outline-primary">글수정</a>
		</div>
		<div>
			댓글
			<div>
				<c:forEach items="${boardtaillist}" var="boardtail">
					<div style="border:1px solid #ddd; padding: 1rem; margin: 0.5rem;">
						<div style="position: relative; padding:0.5rem; color:#999;">
							작성자<div>${boardtail.name}</div>
							<div style="position: absolute; top:0; right: 0;">
								작성날짜시간<div>${boardtail.wdate}</div>
							</div>
						</div>
						<hr>
						내용
						<div style="height: 4rem;">${boardtail.tcontent}</div>
					</div>
				</c:forEach>
			</div>
			<div style="padding: 0.5rem;">
				<h5>댓글작성</h5>
				<form action="/boardtail/insert">
					<input type="hidden" name="fk_id" value="${board.id}"/>
					작성자<input class="form-control" type="text" name="name"/><br>
					내용
					<textarea class="form-control" rows="3" cols="" name="tcontent"></textarea>
					<input class="btn btn-outline-primary mt-3" type="submit" value="저장">
				</form>
			</div>
		</div>
	</div>
	<hr>
	<div class="container">copyright &copy; 대구 박길동님이 다 만듬. All Rights
		Reserved.</div>
</body>
</html>