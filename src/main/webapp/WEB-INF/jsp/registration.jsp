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
                            <form:form method="POST" modelAttribute="userRegForm" class="form-signin">
                                <div>
                                    <span>${message}</span>
                                </div>

                                <spring:bind path="login">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="login">Логин</label>
                                        <form:input type="text" path="login" class="form-control"
                                                    autofocus="true"></form:input>
                                        <form:errors path="login"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="password">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="password">Пароль</label>
                                        <form:input type="password" path="password" class="form-control"></form:input>
                                        <form:errors path="password"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="confirmPassword">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="confirmPassword">Подтвердите пароль</label>
                                        <form:input type="password" path="confirmPassword"
                                                    class="form-control"></form:input>
                                        <form:errors path="confirmPassword"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="username">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="username">Имя</label>
                                        <form:input type="text" path="username" class="form-control"
                                                    autofocus="true"></form:input>
                                        <form:errors path="username"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="surname">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="surname">Фамилия</label>
                                        <form:input type="text" path="surname" class="form-control"
                                                    autofocus="true"></form:input>
                                        <form:errors path="surname"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="age">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="age">Возраст</label>
                                        <form:input type="text" path="age" class="form-control" placeholder="Возраст"
                                                    autofocus="true"></form:input>
                                        <form:errors path="age"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="city">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="city">Город</label>
                                        <form:input type="text" path="city" class="form-control"
                                                    autofocus="true"></form:input>
                                        <form:errors path="city"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="sex">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="sex">Пол</label>
                                        <form:select path="sex" class="form-control" autofocus="true">
                                            <option value="мужчина">мужчина</option>
                                            <option value="женщина">женщина</option>
                                        </form:select>
                                        <form:errors path="sex"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="interests">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="interests">Интересы</label>
                                        <form:input type="text" path="interests" class="form-control"
                                                    autofocus="true"></form:input>
                                        <form:errors path="interests"></form:errors>
                                    </div>
                                </spring:bind>

                                <div>
                                    <span>${error}</span>
                                </div>
                                <input name="reg" id="reg" class="btn btn-block login-btn mb-4" type="submit"
                                       value="Зарегистрироваться">
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>