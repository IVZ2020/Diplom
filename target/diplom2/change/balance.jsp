<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>


<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.css">
<script src="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change ${sessionScope.currentUser.name} balance</title>
</head>
<body>
<div>
    <h3>Change user ${sessionScope.currentUser.name} balance</h3>
</div>

<header class="main-header-area">
    <!-- Main Header Area Start -->
    <nav class="navbar navbar-light bg-faded">
        <div class="nav navbar-nav">
            <a class="nav-item nav-link active" href="/mainPage">Главная страница <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/calcServlet">Калькулятор</a>
            <a class="nav-item nav-link" href="logoutServlet">Выход</a>
            <a class="nav-item nav-link" href="/help">Помощь</a>
        </div>
    </nav>
    <!-- Main Header Area End -->
</header>

<form method="post" action="/changeUserBalanceServlet">
    <input name="newBalance" placeholder="New Balance" type="number">
    <button>Change</button>
</form>

<c:if test="${sessionScope.doubleInvalidate != null}">
    <p>${sessionScope.doubleInvalidate}</p>
</c:if>

<c:if test="${sessionScope.currentUser.role == 1}">
    <a href="/adminCabinet">В личный кабинет</a>
</c:if>

<c:if test="${sessionScope.currentUser.role == 2}">
    <a href="/userCabinet">В личный кабинет</a><br>
</c:if>

<c:if test="${sessionScope.currentUser.role == 3}">
    <a href="/moderatorCabinet">В личный кабинет</a><br>
</c:if>

<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
