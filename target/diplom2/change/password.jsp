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
    <title>Change ${sessionScope.userForChange.name} password</title>
</head>
<body>
<div>
    <h3>Change ${sessionScope.userForChange.name} password</h3>
</div>
<form method="post" action="/changeUserPasswordServlet">
    <input name="newPassword" placeholder="New Password" type="text">
    <button>Change</button>
</form>

<c:if test="${sessionScope.passwordInvalidate != null}">
    <p>${sessionScope.passwordInvalidate}</p>
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

<a href="/mainPage" name="exit">На главную</a><br>
<a href="/logoutServlet" name="exit">Выход</a><br>
</body>
</html>
