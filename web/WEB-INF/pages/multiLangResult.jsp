<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Multiple Language Result</title>
</head>
<body>
<p>
    <a href="multiLang.controller?locale=zh-TW">中文</a>
    <a href="multiLang.controller?locale=en-US">英文</a>
</p>
<spring:message code="program.error"/>
</body>
</html>
