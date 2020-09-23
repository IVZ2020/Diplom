<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authorization</title>
</head>
<body>

    <form method="post" action="/auth">
        <input name="login" value="${requestScope.login}" placeholder="1" type="text">
        <input name="password" placeholder="1" type="password">
        <button>Войти</button>
    </form>
${requestScope.message}

<a href="/mainPage" name="exit">На главную</a>

</body>
</html>