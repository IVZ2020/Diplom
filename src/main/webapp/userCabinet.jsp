<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.09.2020
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserCabinet</title>
</head>
<body>
<p>Личный кабинет пользователя ${sessionScope.currentUser.name}</p>

<a href="/mainPage" name="exit">На главную</a>


</body>
</html>
