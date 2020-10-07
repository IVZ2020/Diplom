<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ModeratorCabinet</title>
</head>
<body>
<p>Личный кабинет модератора ${sessionScope.currentModerator}</p>

<p>Сообщения всем пользователям</p>
<p>Сообщение конкретному пользователю</p>
<p>Вывод в файл переписки с пользователем</p>
<p>Вывод на экран переписки с пользователем</p>
<p>Поиск фразы в переписке с конкретным пользователем</p>

<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
