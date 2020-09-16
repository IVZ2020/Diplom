<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Регистрация пользователя</title>
</head>
<body>

<form method="post" action="/regUser">
    <input name="userName" placeholder="Имя" type="text">
    <input name="userLastName" placeholder="Фамилия" type="text">
    <input name="userLogin" placeholder="Логин" type="text">
    <input name="userPassword" placeholder="Пароль" type="password">
    <button>Submit</button>
</form>
<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
