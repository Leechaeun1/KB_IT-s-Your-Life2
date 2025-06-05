<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>👶 손님이 주문하러 왔어요!</h1>
📝 "${menu.name}" (가격: ${menu.price}원)를 주문합니다.<br/>
<input type="submit" value="추가"><br/>
<a href="/">🏠 돌아가기</a>
</body>
</html>
