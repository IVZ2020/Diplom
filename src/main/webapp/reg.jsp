<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>Registration</p>

<form method="post" name="registration" action="/reg">
    <input name="name" value="Имя" type="text">
    <input name="lastName" value="Фамилия" type="text">
    <input name="login" value="Логин" type="text">
    <input name="pass" value="Пароль" type="password">
    <button>Submit</button>

</form>
</body>
</html>
