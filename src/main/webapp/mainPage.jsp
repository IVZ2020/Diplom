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


    <h4 align="center">Main Page</h4>

    <c:if test="${requestScope.userAdded != null}">
        <h4 align="center">${requestScope.userAdded}</h4>
        <h5 align="center"><a href="/mainPage">На главную</a></h5>
    </c:if>

    <c:if test="${sessionScope.userAuthorizedMessage != null}">
    <p align="center">${sessionScope.userAuthorizedMessage}</p>
        <ol style="list-style: none">
            <c:forEach var="menuItem" items="${sessionScope.mainMenuWithAuthItemsList}">
                <li><h5 align="center"><a href="/${menuItem.menuLink}">${menuItem.menuRus}</a></h5></li>
            </c:forEach>
        </ol>
        <h5 align="center"><a href="/logoutServlet">logout</a></h5>
    </c:if>

    <c:if test="${requestScope.mainMenu != null}">
        <ol style="list-style: none">
            <c:forEach var="menuItem" items="${requestScope.mainMenu}">
                <li><h5 align="center"><a href="/${menuItem.menuLink}">${menuItem.menuRus}</a></h5></li>
            </c:forEach>
        </ol>
    </c:if>

</body>
</html>