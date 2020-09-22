<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

<c:if test="${SessionScope.currentAdmin == null && SessionScope.currentUser == null}">

    <ol style="list-style: none">
        <c:forEach var="menuItem" items="${requestScope.menuItemsList}">
            <li><a href="/${menuItem.menuLink}">${menuItem.menuRus}</a></li>
        </c:forEach>
    </ol>
</c:if>

</body>
</html>