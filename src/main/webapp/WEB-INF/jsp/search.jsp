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
                        <h2>Вот что нашлось:</h2>
                        <div class="card-body">
                            <form:form method="GET" class="form-signin">

                                <table border="1">
                                    <tr style="font-weight:bold">
                                        <td>
                                            <c:out value="Имя"/>

                                        </td>
                                        <td>
                                            <c:out value="Фамилия"/>
                                        </td>
                                        <td>
                                            <c:out value="Пол"/>
                                        </td>
                                        <td>
                                            <c:out value="Возраст"/>
                                        </td>
                                        <td>
                                            <c:out value="Город"/>
                                        </td>
                                        <td>
                                            <c:out value="Интересы"/>
                                        </td>
                                    </tr>

                                    <c:forEach var="userInfo" items="${searchList}">
                                        <tr>
                                            <td>
                                                <c:out value="${userInfo.username}"/>

                                            </td>
                                            <td>
                                                <c:out value="${userInfo.surname}"/>
                                            </td>
                                            <td>
                                                <c:out value="${userInfo.sex}"/>
                                            </td>
                                            <td>
                                                <c:out value="${userInfo.age}"/>
                                            </td>
                                            <td>
                                                <c:out value="${userInfo.city}"/>
                                            </td>
                                            <td>
                                                <c:out value="${userInfo.interests}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
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