<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="/css/common.css">

<head>
    <title>${title}</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li>로그아웃</li>
            <li>로그인</li>
            <li>리스트</li>
            <li>글쓰기</li>
            <li>좋아요</li>
        </ul>
    </nav>
</header>
<section>
    <jsp:include page="/WEB-INF/view/${page}.jsp"></jsp:include>
</section>


</body>
</html>
