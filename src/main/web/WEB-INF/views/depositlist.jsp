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
    <div class="well">
        <nav>
            <ul>
                <%--<li><a href="<c:url value='/create-user' />">Add user</a></li>--%>
                <li><a href="<c:url value='/home' />">Home</a></li>
                <li><a href="<c:url value='/list' />">Show User List</a></li>
                <li><a href="<c:url value='/bill-list' />">Al Users Deposits</a></li>
                <li><a href="<c:url value='/bank' />">Bank Bills</a></li>
            </ul>
        </nav>
    </div>
    <div>
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Deposits</span></div>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <%--<th width="300"></th>--%>
                <%--<th width="300"></th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${deposits}" var="deposit">
                <tr>
                    <td>${deposit.name}</td>
                        <%--<td><a href="<c:url value='/choose-deposit-${user.id}' />" class="btn btn-warning custom-width">add dep</a></td>--%>
                        <%--<td><a href="<c:url value='/show-deposit-${user.id}' />" class="btn btn-warning custom-width">dep list</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
