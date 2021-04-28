<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/write?no=${param.no }" method="post">
		<div>
			제목 : <input type="text" name="title" value="${data.getTitle() }" required="required">
		</div>
		<div>
			내용 : <input type="text" name="content" value="${data.getContent() }" required="required">
		</div>
		<div>
			<input type="submit" value="글쓰기">
			<button type="button" onclick="history.back()">뒤로가기</button>
		</div>
	</form>
</body>
</html>