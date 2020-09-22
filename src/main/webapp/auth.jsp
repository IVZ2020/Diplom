<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Authorization</title>
</head>
<body>


<c:if test="${sessionScope.currentLogin}">
    <p>${sessionScope.wrongLogin}</p>
    <form method="post" action="/auth">
        <input name="authLogin" placeholder="Логин" type="text">
        <input name="authPassword" placeholder="Пароль" type="password">
        <button>Войти</button>
    </form>
</c:if>

<c:if test="${sessionScope.wrongPass}">
        <p>${sessionScope.wrongPass}</p>
        <form method="post" action="/auth">
            <input name="authLogin" value="${sessionScope.currentLogin}" type="text">
            <input name="authPassword" placeholder="Пароль" type="password">
            <button>Войти</button>
        </form>
</c:if>

<form method="post" action="/auth">
    <input name="authLogin" type="text">
    <input name="authPassword" type="password">
    <button>Войти</button>
</form>

<a href="/mainPage" name="exit">На главную</a>

</body>
</html>