<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Регистрация пользователя</title>
</head>
<body>

<form method="post" action="/regUser">
    <input name="name" placeholder="Имя" type="text">
    <input name="lastName" placeholder="Фамилия" type="text">
    <input name="login" placeholder="Логин" type="text">
    <input name="pass" placeholder="Пароль" type="password">
    <button>Submit</button>
    <a href="mainPage.jsp" name="exit">На главную</a>
</form>
</body>
</html>
