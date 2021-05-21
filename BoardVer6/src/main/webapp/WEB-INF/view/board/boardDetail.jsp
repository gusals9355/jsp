<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div><a href="list">리스트로 돌아가기</a></div>
<div>글번호 : <span id="iboard"></span></div>
<div>글제목 : <span id="title"></span> </div>
<div>글내용 : <span id="ctnt"></span> </div>
<div>작성자 : <span id="unm"></span> |
	 작성일 : <span id="regdt"></span>
</div>
<div id="ctnt"></div>

<script>
	function ajax(iboard){
		const param = { iboard }
		const init = {
				method: 'POST',
			    body: new URLSearchParams(param)
			}
			
			fetch('/board/detail',init)
			.then(function(res){
				return res.json();
			}).then(function(myJson){
				console.log(myJson);
				setData(myJson);
			});
	}
	
	ajax(${param.iboard});
	
	function setData(data){
		var iboard = document.querySelector('#iboard');
		iboard.innerText=data.iboard;
		
		document.querySelector('#unm').innerText = data.unm;
		document.querySelector('#regdt').innerText = data.regdt;
		document.querySelector('#title').innerText = data.title;
		document.querySelector('#ctnt').innerText = data.ctnt;
	}
</script>