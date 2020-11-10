<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<html>
<head>
    <title>ModeratorCabinet</title>
</head>
<body>
<div>
    <h4 align="center">Личный кабинет модератора ${sessionScope.currentModerator}</h4>
</div>

<c:forEach var="item" items="${sessionScope.userFieldList}">
    <p>${item}</p>
</c:forEach>

<c:forEach var="value" items="${sessionScope.userFieldsValue}">
    <p>${value}</p>
</c:forEach>

<a href="/logoutServlet">Logout</a>

<p>Сообщения всем пользователям</p>
<p>Сообщение конкретному пользователю</p>
<p>Вывод в файл переписки с пользователем</p>
<p>Вывод на экран переписки с пользователем</p>
<p>Поиск фразы в переписке с конкретным пользователем</p>

<a href="/mainPage" name="exit">На главную</a>
<a href="/logoutServlet">Logout</a>
</body>
</html>
