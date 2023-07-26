<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form action="hello2.controller" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"></td>
            <td>${errors.name}</td>
        </tr>
        <tr>
            <td><button type="submit">Send</button></td>
        </tr>
    </table>
</form>
</body>
</html>
