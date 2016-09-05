<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="generic-container">
    <div class="well lead">Review</div>
    <form:form method="POST" modelAttribute="review" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Title</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="title" id="title" class="form-control input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="title" id="title" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="title" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="shortDescription">Description</label>
                <div class="col-md-7">
                    <form:input type="text" path="shortDescription" id="shortDescription" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="shortDescription" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="text">Text</label>
                <div class="col-md-7">
                    <form:input type="text" path="text" id="text" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="text" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="pictureSource">Picture</label>
                <div class="col-md-7">
                    <form:input type="text" path="pictureSource" id="pictureSource" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="pictureSource" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/reviewslist' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Create" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/reviewslist' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>