<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Takoyaki</title>
</head>
<body>
<h1>🐙 타코야끼 타이문에 오신 걸 환영합니다 🐙</h1>
<br/>
오늘의 첫 손님을 맞이할 준비가 되셨나요?<br/>
<input type="button" value="👶 첫 손님 등장시키기" onclick="location.href='/order/new'">
<hr/>
<a href="/menu/list">메뉴판 보러가기</a>
</body>
</html>
