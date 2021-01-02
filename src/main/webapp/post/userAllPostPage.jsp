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
    <title>AllPostPage</title>
</head>
<body>
    <h4>Переписка пользователя "${sessionScope.currentUser.login}"</h4>

    <c:if test="${requestScope.newListOfDialogs != null}">
        <c:forEach items="${requestScope.newListOfDialogs}" var="dialog">
            <div class="border"><br>
                    <a href="/correspondenceServlet?receiverid=${dialog.userReceiver.id}">Переписка с <strong>${dialog.userReceiver.name}</strong></a><br>
                    <button><a href="/sendMessageServlet?receiverid=${dialog.userReceiver.id}">Написать</a></button><br>
            </div>
        </c:forEach>
        </c:if>

<%--    <form action="/sendMessageServlet" method="post">--%>
<%--        <c:forEach items="${requestScope.getAllUsersHashList}" var="receiver">--%>
<%--            <a href="/sendMessageServlet?receiverid=${receiver.id}">Новое сообщение</a> ${receiver.login}<br>--%>
<%--        </c:forEach>--%>
<%--    </form>--%>

    <form action="/sendMessageServlet" method="get">
        <h3>Выберете пользователя для сообщения:</h3>
    <select name="receiverid">
        <c:forEach items="${requestScope.getAllUsersHashList}" var="receiver">
            <option value="${receiver.id}">${receiver.login}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Написать">
<%--        <button>Написать</button>--%>
    </form>

    <c:if test="${sessionScope.currentUser.role == 2}">
        <a href="/adminCabinet">В личный кабинет</a><br>
    </c:if>
    <c:if test="${sessionScope.currentUser.role == 1}">
        <a href="/userCabinet">В личный кабинет</a><br>
    </c:if>
    <a href="/logoutServlet">Выход</a><br>
    <a href="/mainPage">На главную</a><br>

    Сформировать диалог<br>
    Сформировать список юзеров с диалогами<br>

</body>
</html>
