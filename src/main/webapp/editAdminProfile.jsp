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
    <title>Edit ${sessionScope.currentUser.name} profile</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <c:set var="currentUser" value="${sessionScope.userForChange}">
            </c:set>
            <p><a href="/change/name?id=${currentUser.id}">Изменить имя</a></p>
            <p><a href="/change/lastName.jsp">Изменить фамилию</a></p>
            <p><a href="/change/login.jsp">Изменить логин</a></p>
            <p><a href="/change/password.jsp">Изменить пароль</a></p>
            <p><a href="/change/salary.jsp">Изменить зарплату</a></p>
            <p><a href="/change/income.jsp">Изменить иные доходы</a></p>
        </div>
        <div class="col-sm">
            <p><c:out value="${currentUser.name}"></c:out></p>
            <p><c:out value="${currentUser.lastName}"></c:out></p>
            <p><c:out value="${currentUser.login}"></c:out></p>
            <p><c:out value="${currentUser.pass}"></c:out></p>
            <p><c:out value="${currentUser.salary}"></c:out></p>
            <p><c:out value="${currentUser.income}"></c:out></p>
        </div>
    </div>
</div>

<%--<a href="/mainPage" name="exit"><p>На главную</p></a>--%>
<a href="/logoutServlet" name="logout"><p>Logout</p></a>

</body>
</html>


<%--<table class="table table-striped table-bordered">--%>
<%--    <tr>--%>
<%--        <c:forEach var="item" items="${sessionScope.adminFieldList}">--%>
<%--            <th>${item}</th>--%>
<%--        </c:forEach>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <c:forEach var="value" items="${sessionScope.adminFieldsValue}">--%>
<%--            <th>${value}</th>--%>
<%--        </c:forEach>--%>
<%--    </tr>--%>
<%--</table>--%>