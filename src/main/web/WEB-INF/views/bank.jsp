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
    <%--<div class="well">--%>
    <%--<nav>--%>
    <%--<ul>--%>
    <%--<li><a href="<c:url value='/list' />">Show User List</a></li>--%>
    <%--<li><a href="<c:url value='/home' />">Home</a></li>--%>
    <%--<li><a href="<c:url value='/deposit-list' />">Deposit List</a></li>--%>
    <%--<li><a href="<c:url value='/bill-list' />">All Users Deposits</a></li>--%>
    <%--</ul>--%>
    <%--</nav>--%>
    <%--</div>--%>
    <jsp:include page="layout/menu.jsp"/>
    <div>
        <!-- Default panel contents -->
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
            <c:forEach items="${bills}" var="bill">
                <tr>
                    <td>${bill.name}</td>
                    <td>${bill.code}</td>
                    <td>${bill.moneySum}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="<c:url value='/end-bank-day' />" class="btn btn-danger custom-width">End Day</a>
    </div>

</div>
</body>
</html>

