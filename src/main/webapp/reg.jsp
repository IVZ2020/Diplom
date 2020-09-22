<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>Кого будем регистрировать?</p>

<form method="post" action="/reg">
    <select name="SelectRole">
        <option selected value="user">Пользователь</option>
        <option value="admin">Администратор</option>
    </select>
    <button>Регистрация</button>

</form>
<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
