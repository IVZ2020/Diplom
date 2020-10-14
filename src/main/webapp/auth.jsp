<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authorization</title>
</head>
<body>

    <form method="post" action="/auth">
        <input name="login" value="${requestScope.login}" placeholder="Login" type="text">
        <input name="password" placeholder="Password" type="password">
        <button>Войти</button>
    </form>
    <p>${requestScope.message}</p>

<a href="/mainPage" name="exit">На главную</a>

</body>
</html>