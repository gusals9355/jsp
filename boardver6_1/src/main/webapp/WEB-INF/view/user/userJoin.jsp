<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>join</h1>
<form id="frm" action="/user/join" method="post" onsubmit="return frmChk();">
    <div>
        <input type="text" name="uid" placeholder="아이디">
        <button type="button" id="btnChkId">중복확인</button>
    </div>
    <div id="chkUidResult"></div>
    <div>
        <input type="password" name="upw" placeholder="비밀번호">
    </div>
    <div>
        <input type="password" id="chkUpw" placeholder="비밀번호 확인">
    </div>
    <div>
        <input type="radio" name="gender" value="0" checked> 남자
        <input type="radio" name="gender" value="1"> 여자
    </div>
    <div>
        <input type="text" name="unm" placeholder="이름">
    </div>
    <div>
        <input type="submit" value="확인">
        <input type="reset" value="초기화">
    </div>
</form>
<script src="/js/join.js"></script>