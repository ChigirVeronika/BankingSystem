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
        <div class="panel-heading"><span class="lead">List of Credits</span></div>
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
                <c:if test="${deposit.agreementNumber == 2}">
                    <tr>
                        <td>${deposit.name}</td>
                            <%--<td><a href="<c:url value='/choose-deposit-${user.id}' />" class="btn btn-warning custom-width">add dep</a></td>--%>
                            <%--<td><a href="<c:url value='/show-deposit-${user.id}' />" class="btn btn-warning custom-width">dep list</a></td>--%>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>

