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
			<th>${data.title }
			<td>${data.readCount }
		<tr>
			<td colspan="2" >${data.getContent() }
	</table>
	<a href="/del?no=${param.no }"><input type="button" value="삭제"></a>
	<button type="button" onclick="location.href='/list'">list로 이동!</button>
	<a href="/mod?no=${param.no }"><input type="button" value="수정"></a>
	<hr>
	<form action="" method="get">
	id <input type="text" name="id" value="" readonly="readonly" > <br>
	댓글 <textarea rows="5" cols="10" name="reple" required="required"></textarea>
	<input type="submit" value="확인" > 
	</form>
	<hr>
	<form action="" method="get">
	댓글달기!<br>
	id <input type="text" name="id" required="required" > <br>
	pw <input type="password" name="pw" required="required"> <br>
	댓글 <textarea rows="5" cols="10" name="reple" required="required"></textarea>
	<input type="submit" value="확인" > 
	</form>
</body>
</html>