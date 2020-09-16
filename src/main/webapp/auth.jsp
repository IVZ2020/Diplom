<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Auth</title>
</head>
<body>
<p>Auth</p>
<form method="post" action="/auth">
    <input name="authLogin" placeholder="Логин" type="text">
    <input name="authPassword" placeholder="Пароль" type="password">
    <input name="selectAdmin" type="radio" value="adminSelected"> Войти как администратор
    <button>Войти</button>
</form>
<a href="/mainPage" name="exit">На главную</a>

</body>
</html>