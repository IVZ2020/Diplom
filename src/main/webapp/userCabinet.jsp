<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>
<div>
<h4>Личный кабинет ${sessionScope.currentUser.name}</h4>
</div>

<header class="main-header-area">
    <!-- Main Header Area Start -->
    <nav class="navbar navbar-light bg-faded">
        <div class="nav navbar-nav">
            <a class="nav-item nav-link active" href="/mainPage">Главная страница</a>
            <a class="nav-item nav-link" href="/calcServlet">Калькулятор</a>
            <a class="nav-item nav-link" href="logoutServlet">Выход</a>
            <a class="nav-item nav-link" href="/help">Помощь</a>
        </div>
    </nav>
    <!-- Main Header Area End -->
</header>

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

    <ol style="list-style: none">
        <c:forEach var="menuItem" items="${sessionScope.userMenu}">
            <li><a href="/${menuItem.menuLink}?useridforchange=${sessionScope.currentUser.id}">${menuItem.menuRus}</a></li>
        </c:forEach>
    </ol>
</div>

<p>Вывод истории операций в файл</p>
<p>Добавление расходов/доходов</p>
<p>Баланс</p>
<p>Поиск операции по дате/сумме/названию</p>
<p>Конвертер валюты</p>

<a href="/mainPage" name="exit">На главную</a>


</body>
</html>
