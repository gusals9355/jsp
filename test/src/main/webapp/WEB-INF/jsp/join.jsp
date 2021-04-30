<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	
	<form action="/login" method="post">
		<div>id : <input type="text" name="id" placeholder="id" required="required"></div>
		<div>pw : <input type="password" name="pw" placeholder="pw" required="required"></div>
		<div>email : <input type="email" name="email" placeholder="email" required="required"></div>
		<input type="submit" value="회원가입">
		<input type="button" value="뒤로가기" onclick="history.back()">
	</form>
</body>
</html>