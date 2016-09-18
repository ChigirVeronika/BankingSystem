<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BankingSystem</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <script src="../js/registrationValidation.js"></script>

    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="generic-container">
    <jsp:include page="layout/menu.jsp"/>
    <div class="well lead">Deposit</div>
    <form action="/choose-deposit-${userId}" method="post" class="nm-block nm-add-at-line">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable">Deposit Name</label>
                <div class="col-md-7">
                    <select id="deposit" name="deposit">
                        <c:forEach var="deposit" items="${deposits}">
                            <option name="deposit" value="${deposit.name}">
                                <c:out value="${deposit.name}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable">Deposit money</label>
                <div class="col-md-7">
                    <input type="number" min="1" name="moneySum" class="form-control input-sm" required>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form>
</div>
</body>
</html>

