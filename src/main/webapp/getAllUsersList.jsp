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
    <title>Список всех пользователей</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <c:forEach var="user" items="${sessionScope.allUsersList}">
            <div class="col-md">
<%--                <form method="get" action="/editUserProfile?id=${user.id}">--%>
<%--                    <c:set var="userIdForEditProfile" scope="session" value="${user.id}"></c:set>--%>
<%--                    <input value="${user.id}" name="userIdForEditProfile">--%>
<%--                    <button>Изменить</button>--%>
<%--                </form>--%>
    <a href="/editUserProfile?id=${user.id}">Change</a>
                <table class="table table-striped table-bordered">
                    <tr style="border: 2px">
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Логин</th>
                        <th>Пароль</th>
                        <th>Роль</th>
                        <th>Баланс</th>
                        <th>Зарплата</th>
                        <th>Иные доходы</th>
                    </tr>
                    <tr>
                        <th>${user.name}</th>
                        <th>${user.lastName}</th>
                        <th>${user.login}</th>
                        <th>${user.pass}</th>
                        <th>${user.role}</th>
                        <th>${user.balance}</th>
                        <th>${user.salary}</th>
                        <th>${user.income}</th>
                    </tr>
                </table>
            </div>
            </form>
        </c:forEach>
    </div>
    <a href="/mainPage" name="exit"><p>На главную</p></a>
    <a href="/logoutServlet" name="logout"><p>Logout</p></a>
<%--</div>  <script>--%>
<%--    function isEmail() {--%>
<%--        var str = document.getElementById("email").value;--%>
<%--        var status = document.getElementById("status");--%>
<%--        var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;--%>
<%--        if (re.test(str)) status.innerHTML = "Адрес правильный";--%>
<%--        else status.innerHTML = "Адрес неверный";--%>
<%--        if(isEmpty(str)) status.innerHTML = "Поле пустое";--%>
<%--    }--%>
<%--    function isEmpty(str){--%>
<%--        return (str == null) || (str.length == 0);--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
