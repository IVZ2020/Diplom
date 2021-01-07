<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<div>
    <h4>Регистрация нового пользователя</h4>
</div>

<c:if test="${requestScope.userExist != null}">
    <p>Пользователь c таким логином уже существует</p>
    <p>${requestScope.userExist}</p>
</c:if>

<form method="post" action="/reg">
    <input name="userName" placeholder="Имя" type="text">
    <input name="userLastName" placeholder="Фамилия" type="text">
    <input name="userLogin" placeholder="Логин" type="text">
    <input name="userPassword" placeholder="Пароль" type="password">
    <button>Submit</button>
</form>

<c:if test="${sessionScope.nameInvalid != null}">
    <p>${sessionScope.nameInvalid}</p>
</c:if>
<c:if test="${sessionScope.lastNameInvalid != null}">
    <p>${sessionScope.lastNameInvalid}</p>
</c:if>
<c:if test="${sessionScope.loginInvalid != null}">
    <p>${sessionScope.loginInvalid}</p>
</c:if>
<c:if test="${sessionScope.passwordInvalid != null}">
    <p>${sessionScope.passwordInvalid}</p>
</c:if>

<a href="/mainPage" name="exit">На главную</a>

</body>
</html>
