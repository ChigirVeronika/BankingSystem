<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    <div class="well">
        <nav>
            <ul>
                <li><a href="<c:url value='/list' />">Show User List</a></li>
                <li><a href="<c:url value='/home' />">Home</a></li>
                <li><a href="<c:url value='/deposit-list' />">Deposit List</a></li>
                <li><a href="<c:url value='/bank' />">Bank Bills</a></li>
            </ul>
        </nav>
    </div>
    <div>
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users Deposits</span></div>
        <table>
            <thead>
            <tr>
                <th>User</th>
                <th>Deposit Type</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Money</th>
                <th width="200"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bills}" var="bill">
                <tr>
                    <td>${bill.creator.getFirstName()} ${bill.creator.getLastName()}</td>
                    <td>${bill.deposit.getName()}</td>
                    <td>${bill.deposit.getStartDate()}</td>
                    <td>${bill.deposit.getEndDate()}</td>
                    <td>${bill.moneySum}</td>
                    <c:if test="${bill.deposit.getType()=='Return'}" >
                        <td><a href="<c:url value='/delete-deposit-${bill.id}' />" class="btn btn-warning custom-width">return</a></td>
                    </c:if>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
