<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="studyForm" action="step3">
	email : <form:input path="email" /><br/>
	password : <form:password path="password" /><br/>
	confirmpassword : <form:password path="confirmpassword" /><br/>
	<c:if test="${not empty error }">
		<span style="color:red; font-size: 2rem;">패스워드를 확인하세요.${error}</span><br>
	</c:if>
	name : <form:input path="name"/><br/>
	<input type="submit" value="가입"/>
</form:form>
</body>
</html>
