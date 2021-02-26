<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.01.2021
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change ${sessionScope.userForChange.name} role</title>
</head>
<body>

    <form action="/changeUserRoleServlet" method="post">
        <select name="newUserRole">
            <option value="1">Права юзера</option>
            <option value="2">Права админа</option>
            <option value="3">Права модератора</option>
        </select>
        <button>Изменить</button>
    </form>
</body>
</html>
