<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
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
    <div class="well">
        <a href="<c:url value='/list' />">User list</a>
        <a href="<c:url value='/home' />">Home</a>
    </div>
    <div class="well lead">Deposit</div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="moneySum">Deposit money</label>
            <div class="col-md-7">
                <form:input type="number" min="1" path="moneySum" id="moneySum" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="moneySum" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="moneySum">Deposit money</label>
            <div class="col-md-7">
                <form:input type="number" min="1" path="moneySum" id="moneySum" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="moneySum" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                        href="<c:url value='/home' />">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a
                        href="<c:url value='/home' />">Cancel</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    </form:form>
</div>
</body>
</html>

