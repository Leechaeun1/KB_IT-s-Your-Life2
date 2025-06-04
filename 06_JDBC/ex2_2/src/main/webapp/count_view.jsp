<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>방문자수 조회하기 화면</h1>
<%
    // application 객체에서 countValue 값 꺼내기, 형변환 필수
    int count=(Integer) application.getAttribute("countValue");
%>

현재까지 총 방문자수: <%= count%>
</body>