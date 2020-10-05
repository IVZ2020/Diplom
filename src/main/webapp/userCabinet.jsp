<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>UserCabinet</title>
</head>
<body>
<p>Личный кабинет пользователя ${sessionScope.currentUser.name}</p>

    <c:forEach var="item" items="${sessionScope.userFieldList}">
        ${item}
    </c:forEach>

    <c:forEach var="value" items="${sessionScope.userFieldsValue}">
        <p>${value}</p>
    </c:forEach>
<%--    <c:forEach var="field" items="${sessionScope.currentUser}">--%>
<%--    <p>"${field}"</p>--%>
<%--    </c:forEach>--%>

<%--<c:if test="${!sessionScope.currentUser}">--%>
<%--    <p><a href="/auth">Авторизуйтесь</a></p>--%>
<%--</c:if>--%>


<a href="/mainPage" name="exit">На главную</a>


</body>
</html>
