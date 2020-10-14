<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>
<p>Личный кабинет пользователя ${sessionScope.currentUser.name}</p>

    <c:forEach var="item" items="${sessionScope.userFieldList}">
        <p>${item}</p>
    </c:forEach>

    <c:forEach var="value" items="${sessionScope.userFieldsValue}">
        <p>${value}</p>
    </c:forEach>

    <a href="/logoutServlet">Logout</a>

<p>Изменения логина и пароля</p>
<p>Вывод истории операций в файл</p>
<p>Добавление расходов/доходов</p>
<p>Баланс</p>
<p>Поиск операции по дате/сумме/названию</p>
<p>Конвертер валюты</p>
<p>Сообщение администратору</p>



<a href="/mainPage" name="exit">На главную</a>


</body>
</html>
