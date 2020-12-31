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
            <div class="border">Диалог с пользователем <strong>${dialog.userReceiver.name}</strong>
                <br>
                    <c:forEach items="${dialog.postList}" var="post">
                        <strong>Сообщение: </strong>${post.post}<br>
                        <i>Отправлено: </i>${post.stringDate}<br>
                    </c:forEach>
                <a href="/sendMessageServlet?receiverid=${dialog.userReceiver.id}">Новое сообщение</a><br>
            </div>
        </c:forEach>
    </c:if>


<%--    <c:if test="${sessionScope.userAllPostPageList != null}">--%>
<%--        <c:forEach items="${sessionScope.userAllPostPageList}" var="post">--%>
<%--            <tr>--%>
<%--                <th>--%>
<%--                    Сообщение от ${post.idReceiver} "${post.post}" отправлено: ${post.stringDate}.--%>
<%--                    <a href="/sendMessageServlet?receiverid=${post.idReceiver}">Написать</a><br>--%>
<%--                </th>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </c:if>--%>

<%--    <c:forEach var="user" items="${requestScope.getListOfAllUsersWhoHasDialogWithCurrentUser}">--%>
<%--        <tr>--%>
<%--            <th>--%>
<%--                <p>${user.name}</p>--%>
<%--            </th>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

    <a href="/logoutServlet">Выход</a><br>
    <a href="/mainPage">На главную</a><br>

    Сформировать диалог<br>
    Сформировать список юзеров с диалогами<br>

</body>
</html>
