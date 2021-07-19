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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

<%--    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link href="${contextPath}/static/css/common.css" rel="stylesheet">--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,700,900' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>" type="text/css">


<%--    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
<%--    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>

</head>

<body>

<div class="registration-form">
    <form:form method="POST" modelAttribute="userRegForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>

        <spring:bind path="login">
            <div class="input-section email-section ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="login" class="email" placeholder="Введите ваш логин"
                            autofocus="true" autocomplete="off"></form:input>
                <div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span>
                    <span class="next-button email"><i class="fa fa-arrow-up"></i></span></div>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="input-section password-section folded ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="password" placeholder="ENTER YOUR PASSWORD HERE"/>
                <div class="animated-button"><span class="icon-lock"><i class="fa fa-lock"></i></span>
                    <span class="next-button password"><i class="fa fa-arrow-up"></i></span></div>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="input-section repeat-password-section folded ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="password" placeholder="REPEAT YOUR PASSWORD HERE"/>
                <div class="animated-button"><span class="icon-repeat-lock"><i class="fa fa-lock"></i></span>
                    <span class="next-button repeat-password"><i class="fa fa-arrow-up"></i></span></div>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

<%--        <spring:bind path="username">--%>
<%--            <div class="input-section password-section folded ${status.error ? 'has-error' : ''}">--%>
<%--                <form:input type="text" path="username" class="password" placeholder="Введите ваше имя"--%>
<%--                            autofocus="true" autocomplete="off"></form:input>--%>
<%--                <div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span>--%>
<%--                    <span class="next-button password"><i class="fa fa-arrow-up"></i></span></div>--%>
<%--                <form:errors path="username"></form:errors>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        <spring:bind path="surname">--%>
<%--            <div class="input-section password-section folded ${status.error ? 'has-error' : ''}">--%>
<%--                <form:input type="text" path="surname" class="password" placeholder="Введите вашу фамилию"--%>
<%--                            autofocus="true" autocomplete="off"></form:input>--%>
<%--                <div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span>--%>
<%--                    <span class="next-button password"><i class="fa fa-arrow-up"></i></span></div>--%>
<%--                <form:errors path="surname"></form:errors>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

        <div class="success">
            <p>ACCOUNT CREATED</p>
        </div>



<%--        <spring:bind path="confirmPassword">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                <form:input type="password" path="confirmPassword" class="form-control"--%>
<%--                            placeholder="Confirm your password"></form:input>--%>
<%--                <form:errors path="confirmPassword"></form:errors>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Имя"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="surname" class="form-control" placeholder="Фамилия"
                            autofocus="true"></form:input>
                <form:errors path="surname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="age">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="age" class="form-control" placeholder="Возраст"
                            autofocus="true"></form:input>
                <form:errors path="age"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="city" class="form-control" placeholder="Город"
                            autofocus="true"></form:input>
                <form:errors path="city"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="sex">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="sex" class="form-control" placeholder="Пол" autofocus="true">
                    <option value="мужчина">мужчина</option>
                    <option value="женщина">женщина</option>
                </form:select>
                <form:errors path="sex"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="interests">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="interests" class="form-control" placeholder="Интересы"
                            autofocus="true"></form:input>
                <form:errors path="interests"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>

    <form>



<%--        <div class="input-section email-section">--%>
<%--            <input class="email" type="email" placeholder="ENTER YOUR E-MAIL HERE" autocomplete="off"/>--%>
<%--            <div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span><span class="next-button email"><i class="fa fa-arrow-up"></i></span></div>--%>
<%--        </div>--%>


    </form>

</div>
<!-- /container -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/static/js/bootstrap.min.js"></script>--%>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="../../resources/js/index.js"></script>


</body>
</html>
