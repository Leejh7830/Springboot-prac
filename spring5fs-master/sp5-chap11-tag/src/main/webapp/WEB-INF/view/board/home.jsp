<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>home</title>
</head>
<body>
	<%@ include file="nav.jsp" %>

	<div class="container">
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="https://jjalbang.today/jjv2fm.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="https://t1.daumcdn.net/cfile/tistory/2270F63E587E354C23?original" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="https://i.pinimg.com/originals/fd/a9/1f/fda91ffc9ddd0115437c45b192fea0d9.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<div style="position: relative; background-color: #eee; margin-top: 1rem">
			<h1>home.jsp</h1>
			<h1 style="position: absolute;
					   right: 1rem;
					   top:0;
					   cursor: pointer;
					   background-color:#bbb;
					   border-radius: 0.5rem;
					   width: 2rem;
					   text-align: center;
					   ">
					   <a style="text-decoration: none;" 
					   href="selectall?pagenum=1"> + </a>
					   </h1>
		</div>
		<div>
			<table class="table">
				<tr><th>순번</th><th>제목</th><th>작성날짜</th></tr>
				<c:forEach var="aaa" items="${list}">
				<tr>
					<td>${aaa.id}</td>
					<td>${aaa.title}</td>
					<td>
					<fmt:parseDate value='${aaa.wdate}' var='day' pattern='yyyymmdd'/>
					<fmt:formatDate value="${day}" pattern="yyyy년  MM월  dd일" /> 
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="container">
		copyright &copy; 대구 박길동님이 다 만듬. All Rights Reserved.
	</div>
</body>
</html>