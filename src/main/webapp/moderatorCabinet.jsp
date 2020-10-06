<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ModeratorCabinet</title>
</head>
<body>
<p>Личный кабинет модератора ${sessionScope.currentModerator}</p>

<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
