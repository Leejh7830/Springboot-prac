<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>hello</title>
</head>
<body>
	<%@ include file="nav.jsp" %>

	<div class="container">
		<form:form action="insert" method="post" 
					modelAttribute="board">
			<div style="position: relative; background-color: #eee; margin-top: 1rem">
				<h1>insert.jsp</h1>
			</div>
			<div class="mb-3">
				<label class="form-label" for="title">글제목</label>
				<form:input class="form-control" path="title" />
				<label class="form-label" for="content">글내용</label>
				<form:textarea class="form-control" path="content" />
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<input class="btn btn-outline-primary" type="submit" value="글저장">
			</div>
		</form:form>
	</div>
	<hr>
	<div class="container">copyright &copy; 대구 박길동님이 다 만듬. All Rights
		Reserved.</div>
</body>
</html>