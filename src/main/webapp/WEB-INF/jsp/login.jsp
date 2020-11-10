<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Template</title>

    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="../../resources/css/login.css"/>" type="text/css">

    <title>Log in with your account</title>

    <%--    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--    <link href="${contextPath}/static/css/common.css" rel="stylesheet">--%>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
    <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
        <div class="container">
            <div class="card login-card">
                <div class="row no-gutters">
                    <div class="col-md-5">
                        <img src="../../resources/images/login.jpg" alt="login" class="login-card-img">
                    </div>
                    <div class="col-md-7">
                        <div class="card-body">
                            <div >
                                <img src="../../resources/images/logo.jpg" alt="logo" class="logo">
                            </div>
                            <form method="POST" action="${contextPath}/login" class="form-signin">
                                <div>
                                    <span>${message}</span>
                                </div>
                                <div class="form-group ${error != null ? 'has-error' : ''}">
                                    <label for="username" class="sr-only">Логин</label>
                                    <input type="text" name="username" id="username" class="form-control"
                                           placeholder="Username" autofocus="true">
                                </div>
                                <div class="form-group mb-4">
                                    <label for="password" class="sr-only">Пароль</label>
                                    <input type="password" name="password" id="password" class="form-control"
                                           placeholder="***********">
                                </div>
                                <div>
                                    <span>${error}</span>
                                </div>
                                <input name="login" id="login" class="btn btn-block login-btn mb-4" type="submit" value="Login">

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <p class="login-card-footer-text">Забыли пароль?&nbsp;&nbsp;
                                <a href="${contextPath}/registration" class="text-reset">Зарегистрироваться</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<!-- /container -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/static/js/bootstrap.min.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
