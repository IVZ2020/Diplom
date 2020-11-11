<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<html>
<head>
    <title>Change ${sessionScope.userForChange.name} login</title>
</head>
<body>

<div>
    <h3>Change login of ${sessionScope.userForChange.name}</h3>
</div>
<form method="post" action="/change/login">
    <input name="newLogin" placeholder="New Login" type="text">
    <button>Change</button>
</form>
<a href="/mainPage" name="exit">На главную</a>
</body>
</html>