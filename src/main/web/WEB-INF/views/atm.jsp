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
    <jsp:include page="layout/atm-menu.jsp"/>
    <div class="well lead">ATM</div>
    <form action="/atm-identify-card-${userId}" method="post" class="nm-block nm-add-at-line">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable">Credit Name</label>
                <div class="col-md-7">
                    <select id="deposit" name="deposit" >

                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable">Card number</label>
                <div class="col-md-7">
                    <input type="number" min="1000" max="9999" name="code" class="form-control input-sm" required>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">

                <input type="submit" value="OK" class="btn btn-primary btn-sm"/> or <a
                    href="<c:url value='/home' />">Cancel</a>

            </div>
        </div>
    </form>
</div>
</body>
</html>

