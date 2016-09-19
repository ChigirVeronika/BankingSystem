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

    <jsp:include page="layout/menu.jsp"/>
    <div>
        <div class="panel-heading"><span class="lead">List of Users Credits</span></div>
        <table>
            <thead>
            <tr>
                <th>User</th>
                <th>Credit Type</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Money To Pay</th>
                <th width="200"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bills}" var="bill">
                <c:if test="${bill.deposit.getAgreementNumber() == 2}">
                    <tr>
                        <td> ${bill.creator.getFirstName()} ${bill.creator.getLastName()} </td>
                        <td> ${bill.deposit.getName()} </td>
                        <td> ${bill.deposit.getStartDate()} </td>
                        <td> ${bill.deposit.getEndDate()} </td>
                        <td> current: ${bill.moneySum} </td>
                        <c:if test="${bill.deposit.getType()=='First'}" >
                            <td><a href="<c:url value='/close-credit-${bill.id}' />" class="btn btn-warning custom-width">Close</a></td>
                        </c:if>

                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
