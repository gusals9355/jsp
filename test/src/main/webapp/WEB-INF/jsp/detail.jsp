<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Detail${param.no }</h2>
	<table border="1">
		<tr>
			<th>${data.getTitle() }
		<tr>
			<td>${data.getContent() }
	</table>
	<a href="/del?no=${param.no }"><input type="button" value="삭제"></a>
	<button type="button" onclick="history.back()">뒤로가기</button>
	<button type="button" onclick="location.href='/list'">list로 이동!</button>
	<a href="/mod?no=${param.no }"><input type="button" value="수정"></a>
</body>
</html>