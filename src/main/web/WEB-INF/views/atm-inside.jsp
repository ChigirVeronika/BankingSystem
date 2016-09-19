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
    <jsp:include page="layout/atm-menu.jsp"/>
    <div>
        <div class="panel-heading"><span class="lead">Current Bill</span></div>
        <table>
            <thead>
            <tr>
                <th>User</th>
                <%--<th>Deposit type</th>--%>
                <th>Money amount</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${bill.creator.getFirstName()} ${bill.creator.getLastName()}</td>
                <%--<td>${bill.deposit.getName()}</td>--%>
                <td>${bill.moneySum}</td>
            </tr>
            </tbody>
        </table>

        <hr/>

        <form action="/atm-get-money-${bill.id}" method="post" class="nm-block nm-add-at-line">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable">Money to get</label>
                    <div class="col-md-7">
                        <input type="number" min="10" max="500" name="money" class="form-control input-sm" required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="OK" class="btn btn-primary btn-sm"/>
                </div>
            </div>
        </form>

        <hr/>

        <div class="panel-heading"><span class="lead">Current Receipt</span></div>
        <table>
            <thead>
            <tr>
                <th>User</th>
                <%--<th>Deposit type</th>--%>
                <th>Money amount</th>
                <th>Got money</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${bill.creator.getFirstName()} ${bill.creator.getLastName()}</td>
                <%--<td>${bill.deposit.getName()}</td>--%>
                <td>${bill.moneySum}</td>
                <td>${gotmoney}</td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>


