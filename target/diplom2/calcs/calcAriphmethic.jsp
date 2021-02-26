<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.css">
<script src="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.js"></script>

<html>
<head>
    <title>Calc Ariphmethic</title>
</head>
<body>
<form action="/calcServlet" method="post">
    <input placeholder="a" name="a" type="text">
    <input placeholder="b" name="b" type="text">
    <select name="operation">
        <option value="summ">Сумма</option>
        <option value="minus">Разница</option>
        <option value="div">Деление</option>
        <option value="mult">Умножение</option>
    </select>
    <input type="submit" value="Вычислить">
</form>

<c:if test="${requestScope.wrongDigit != null}">
    <p>${requestScope.wrongDigit}</p>
</c:if>

<c:if test="${requestScope.calcResult != null}">
    <p>${requestScope.calcResult}</p>
</c:if>

<c:if test="${requestScope.denyDivision != null}">
    <p>${requestScope.denyDivision}</p>
</c:if>

<c:if test="${requestScope.emptyDigits != null}">
    <p>${requestScope.emptyDigits}</p>
</c:if>

<c:if test="${sessionScope.result != null}">
<p>Результат: ${sessionScope.result}</p>
</c:if>

<c:if test="${sessionScope.currentUser.role == 2}">
    <a href="/adminCabinet">В личный кабинет</a><br>
</c:if>
<c:if test="${sessionScope.currentUser.role == 1}">
    <a href="/userCabinet">В личный кабинет</a><br>
</c:if>
<a href="/logoutServlet">Выход</a><br>
<a href="/mainPage">На главную</a><br>
</body>
</html>
