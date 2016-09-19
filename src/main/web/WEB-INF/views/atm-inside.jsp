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
        <div class="panel-heading"><span class="lead">List of Bank Bills</span></div>
        <table>
            <thead>
            <tr>
                <th>Bank bill type</th>
                <th>Currency type</th>
                <th>Money amount</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${bill.name}</td>
                    <td>${bill.code}</td>
                    <td>${bill.moneySum}</td>
                </tr>
            </tbody>
        </table>

        <a href="<c:url value='/' />" class="btn btn-danger custom-width">End Day</a>
    </div>

</div>
</body>
</html>


