<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${pageContext.request.contextPath} webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" integrity="VjEeINv9OSwtWFLAtmc4JCtEJXXBub00gtSnszmspDLCtC0I4z4nqz7rEFbIZLLU" crossorigin="anonymous"></script>

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Authorization</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<header class="main-header-area">
    <!-- Main Header Area Start -->
    <nav class="navbar navbar-light bg-faded">
        <div class="nav navbar-nav">
            <a class="nav-item nav-link active" href="/mainPage">Главная страница <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/calcServlet">Калькулятор</a>
            <a class="nav-item nav-link" href="logoutServlet">Выход</a>
            <a class="nav-item nav-link" href="/help">Помощь</a>
        </div>
    </nav>
    <!-- Main Header Area End -->
</header>

    <div class="login-register-area mt-no-text">
        <div class="container custom-area">
            <div class="row">
                <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-custom">
                    <div class="login-register-wrapper">
                        <div class="section-content text-center mb-5">
                            <h2 class="title-4 mb-2">Логин</h2>
                            <p class="desc-content">Введите имя пользователя и пароль.</p>
                        </div>
                        <form method="post" action="/auth">
                            <div class="single-input-item mb-3">
                                <input name="login" value="${requestScope.login}" placeholder="Логин" type="text">
                            </div>
                            <div class="single-input-item mb-3">
                                <input name="password" placeholder="Password" type="password">
                            </div>
                            <div class="single-input-item mb-3">
                                <div class="login-reg-form-meta d-flex align-items-center justify-content-between">
                                    <a href="#" class="forget-pwd mb-3">Забыли пароль?</a>
                                </div>
                            </div>
                            <p>${requestScope.message}</p>
                            <div class="single-input-item mb-3">
                                <button class="btn flosun-button secondary-btn theme-color rounded-0">Логин</button>
                            </div>
                            <div class="single-input-item">
                                <a href="/reg">Новый пользователь</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>