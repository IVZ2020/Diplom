<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>pt>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>
<p>Личный кабинет пользователя ${sessionScope.currentUser.name}</p>

<div class="container">
<table border="1" class="table table-striped table-bordered">
    <tr class="thead-dark">
        <c:forEach var="item" items="${sessionScope.userFieldList}">
            <th>${item}</th>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach var="value" items="${sessionScope.userFieldsValue}">
            <th>${value}</th>
        </c:forEach>
    </tr>
</table>
</div>




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
