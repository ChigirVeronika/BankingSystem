<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BankingSystem</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div class="generic-container-add">
    <jsp:include page="layout/menu.jsp"/>
    <div>
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users</span></div>
        <table border-width="3px">
            <thead>
            <tr>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Passport</th>
                <th>Whom Granted</th>
                <th>Granted Date</th>
                <th>Id number</th>
                <th>Email</th>
                <th width="200"></th>
                <th width="200"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.middleName}</td>
                    <td>${user.passportSeries}${user.passportNumber}</td>
                    <td>${user.whomGranted}</td>
                    <td>${user.grantedDate}</td>
                    <td>${user.idNumber}</td>
                    <td>${user.email}</td>
                    <td><a href="<c:url value='/choose-deposit-${user.id}' />" class="btn btn-warning custom-width">Deposit</a></td>
                    <td><a href="<c:url value='/choose-credit-${user.id}' />" class="btn btn-warning custom-width">Credit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>