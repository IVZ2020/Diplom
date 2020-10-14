<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

        <c:if test="${requestScope.userAuthorizedMessage != null}">
        <p>${requestScope.userAuthorizedMessage}</p>
        <p>Check</p>
        <a href="/mainPage" name="exit">На главную</a>
        </c:if>

    <ol style="list-style: none">
        <c:forEach var="menuItem" items="${requestScope.menuItemsList}">
            <li><a href="/${menuItem.menuLink}">${menuItem.menuRus}</a></li>
        </c:forEach>
    </ol>

</body>
</html>