<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>
    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <table>
        <tr>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <td>
                <img src="../../resources/images/logo.jpg" height="50" width="125">
            </td>
            <td>
                <input type="search">
            </td>
            <td>
                <form id="logoutForm" method="post" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </td>
            <td>
                <h4>Welcome, ${pageContext.request.userPrincipal.name} |
                    <a onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h4>
            </td>
            </c:if>
    </table>
    <form:form method="GET" class="form-signin">
        <table>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${userInfo.sex == 'мужчина'}">
                            <img src="../../resources/images/man-1937620_1280.jpg" height="425" width="660">
                        </c:when>
                        <c:otherwise>
                            <img src="../../resources/images/woman-944261_1280.jpg" height="425" width="660">
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>
                                <c:out value="${userInfo.username} ${userInfo.surname}"/>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <c:out value="${userInfo.sex}, ${userInfo.age} г."/>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <c:out value="${userInfo.city}"/>
                                <br>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    В свободное время люблю: <c:out value="${userInfo.interests}"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>
<script src="${contextPath}/static/js/bootstrap.min.js"/>
</body>
</html>