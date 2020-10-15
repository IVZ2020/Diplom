<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
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

<a href="/logoutServlet">logout</a>

</body>
</html>