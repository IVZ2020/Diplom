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
    <title>Money Operations</title>
</head>
<body>

<form action="/moneyEventServlet" method="post">
    <p>Введите сумму:</p>
    <input type="text" placeholder="Введите сумму" name="currentMoneyEventSumm">
    <p>Введите категорию</p>
    <input type="text" placeholder="Введите категорию" name="cathegoryOfGoods">
    <p>Выберете тип операции:</p>
    <select name="typeOfMoneyEvent">
        <option value="expenceEvent">Expence</option>
        <option value="incomeEvent">Income</option>
    </select>

    <c:if test="${requestScope.wrongDigit != null}">
        <p>${requestScope.wrongDigit}</p>
    </c:if>

    <button>Отправить</button>
</form>

</body>
</html>
