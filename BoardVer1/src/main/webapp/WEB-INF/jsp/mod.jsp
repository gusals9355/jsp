<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정${param.no }</h1>
	<form action="/mod" method="post">
		<input type="hidden" name="no" value=${param.no }>
		<div>
			제목 : <input type="text" name="title" value="${data.getTitle() }">
		</div>
		<div>
			내용 : <textarea name="ctnt" cols="10">${data.getCtnt() }</textarea>
		</div>
		<div>
			<input type="submit" value="글수정">
		</div>
	</form>
	<input type="button" value="뒤로가기" onclick="history.back()">
</body>
</html>