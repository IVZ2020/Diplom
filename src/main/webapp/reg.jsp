<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>Регистрация</p>

<c:if test="${requestScope.userAdded}">
    <p>${requestScope.userAdded}</p>
</c:if>

<form method="post" action="/reg">
    <input name="userName" placeholder="Имя" type="text">
    <input name="userLastName" placeholder="Фамилия" type="text">
    <input name="userLogin" placeholder="Логин" type="text">
    <input name="userPassword" placeholder="Пароль" type="password">
    <button>Submit</button>
</form>
<a href="/mainPage" name="exit">На главную</a>

</body>
</html>
