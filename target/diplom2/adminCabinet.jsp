<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>


<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.css">
<script src="https://unpkg.com/bootstrap-table@1.18.0/dist/bootstrap-table.min.js"></script>




<html>
<head>
    <title>AdminCabinet</title>
</head>
<body>

<div>
    <h4 align="center">Личный кабинет администратора ${sessionScope.currentUser.name}</h4>
</div>

<div class="container-fluid" align="center">

    <ol style="list-style: none">
        <c:forEach var="menuItem" items="${sessionScope.adminMenu}">
            <li><a href="/${menuItem.menuLink}">${menuItem.menuRus}</a></li>
        </c:forEach>
    </ol>

</div>

<%--CDN - что это? узнать--%>
<%--Amazon - cloud storage--%>
<%--хранить графический контент у провайдера--%>

<%--отдельная страница--%>
<p>Изменение роли пользователей (наделение правами модератора и/или администратора)</p>
<%--отдетльная страница--%>
<p>Распечатка в файл списка всех пользователей</p>
<%--нажать распечатку, выбрать обзор, место на диске - вариант 1--%>
<%--автоматом скачать файл - вариант 2--%>
<%--Посмотреть статьи про работу с файлами в сервлетах--%>

<p>Доступ к бухгалтерии пользователя</p>
<%--мультиселект, радобаттон--%>

<p>Поиск пользователя</p>
<%--input - найти пользователя. По каким полям? По каким-то параметрам. То есть определиться по каким полям--%>
<%--Искать по буквам - через sql-запрос (лайк-паттерн).--%>
<%--почитать статьи по поиску через гибкий запрос в sql--%>

<p>Общие сообщения всем пользователям</p>
<%--В личном кабинете сделать textarea (html), дизейбл ему поставить--%>
<%--отрегулировать размер. уведомлений не получится пока--%>

<p>Личные сообщения выбранному пользователю</p>
<%--Правильнее - руководить диалогами, а не отдельными сообщениями. Диалог является связующим звеном между двумя пользователями--%>
<%--Отдельная страничка для отправки сообщения в личном кабинете--%>
<%--сообщение - это отдельная таблица с id сообщения, id пользователя, id отправителя, само сообщение, дата, время--%>
<%--перед тем, как открыть окно сообщений, необходимо выбрать из списка конкретного пользователя--%>
<%--При открытии страницы надо уже иметь список отправителей и получателей в сессии--%>
<%--Отсортировать все сообщения по id пользователя.--%>
<%--каждое сообщение привязывается к диалогу. имея на руках id диалога я имею возможность добавлять в него сообщения--%>
<%--у сообщения есть id диалога. Тогда в таблице сообщения: id сообщения, id диалога, само сообщение, дата-время (одна колонка)--%>


<a href="/mainPage" name="exit">На главную</a>
</body>
</html>
