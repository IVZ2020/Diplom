<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.10.2020
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Admin ${sessionScope.currentUser.name} profile</title>
</head>
<body>

Check this page

<table class="table table-success table-borderless">
    <c:forEach var="item" items="${sessionScope.userProfileFields}">
        <tr>
            <c:forEach var="item" items="${sessionScope.userProfileFieldsValues}">
                <td>${item}<button><a href="/changeUserName">Изменить</a></button></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<a href="/mainPage" name="exit">На главную</a>
<a href="/logoutServlet" name="logout">На главную</a>

</body>
</html>
