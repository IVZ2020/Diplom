<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>AdminCabinet</title>
</head>
<body>
<p>Личный кабинет администратора ${sessionScope.currentAdmin}</p>

<c:forEach var="item" items="${sessionScope.adminFieldList}">
    <p>${item}</p>
</c:forEach>

<c:forEach var="value" items="${sessionScope.adminFieldsValue}">
    <p>${value}</p>
</c:forEach>

<a href="/logoutServlet">Logout</a>




<%--Подключить bootstrap попробовать самостоятельно--%>
<%--CDN - что это? узнать--%>
<%--Amazon - cloud storage--%>
<%--хранить графический контент у провайдера--%>

<p>Список всех пользователей</p>
<%--отдельная страница--%>
<p>Изменение имени, фамилии, логина, пароля пользователя</p>
<%--отдельная страница--%>
<p>Изменение роли пользователей (наделение правами модератора и/или администратора)</p>
<%--отдетльная страница--%>
<p>Удаление пользователей</p>
<%--одна кнопка--%>
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
