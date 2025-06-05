<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>📦 주문 결과</h1>
<div>
🎉 "${menu.name}" 주문 성공! <br/>
💰 누적 매출: {}원<br/>
📦 남은 재고: {}<br/>
<a href="/order/new">👩‍🦲 다음 손님 받기</a>
<a href="/">🏠 돌아가기</a>
</div>
<div>
    ❌ 주문 실패! 재고가 부족합니다.<br/>
    📦 남은 재고: 0<br/>
    <a href="/order/new">👩‍🦲 다음 손님 받기</a>
    <a href="/">🏠 돌아가기</a>
</div>
</body>
</html>
