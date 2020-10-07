<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
