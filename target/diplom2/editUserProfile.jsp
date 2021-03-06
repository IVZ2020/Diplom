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
    <title>Edit User Profile</title>
</head>
<body>
<c:set var="userForChange" value="${sessionScope.userForChange}"></c:set>
<c:set var="userForChangeId" value="${userForChange.id}"></c:set>
<div>
    <h4 align="center">Edit ${userForChange.name}Profile</h4>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm">
            <p><a href="/changeUserNameServlet">Изменить имя</a></p>
            <p><a href="/changeUserLastNameServlet">Изменить фамилию</a></p>
            <p><a href="/changeUserLoginServlet">Изменить логин</a></p>
            <p><a href="/changeUserPasswordServlet">Изменить пароль</a></p>
            <c:if test="${sessionScope.currentUser.role == 2}">
                <p><a href="/changeUserRoleServlet">Изменить роль</a></p>
            </c:if>


        </div>
        <div class="col-sm">
            <p><c:out value="${userForChange.name}"></c:out></p>
            <p><c:out value="${userForChange.lastName}"></c:out></p>
            <p><c:out value="${userForChange.login}"></c:out></p>
            <p><c:out value="${userForChange.pass}"></c:out></p>

            <c:if test="${sessionScope.currentUser.role == 2}">
                <p><c:out value="${userForChange.role}"></c:out></p>
            </c:if>
        </div>
    </div>
</div>

<c:if test="${sessionScope.currentUser.role == 1}">
    <a href="/userCabinet"><p>В личный кабинет</p></a>
</c:if>

<a href="/mainPage" name="exit"><p>На главную</p></a>
<a href="/logoutServlet" name="logout"><p>Logout</p></a>
</body>
</html>
