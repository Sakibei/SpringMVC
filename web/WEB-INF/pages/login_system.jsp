<%--suppress HtmlFormInputWithoutLabel --%>
<%--@elvariable id="errors" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginSystem</title>
</head>
<body>
<h3>Form</h3>
<form action="checklogin.controller" method="post">
    <table>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName"></td>
            <td>${errors.name}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="userPwd"></td>
            <td>${errors.pwd}</td>
        </tr>
        <tr>
            <td>
                <button type="submit">Login</button>
            </td>
            <td>${errors.msg}</td>
        </tr>
    </table>
</form>
</body>
</html>
