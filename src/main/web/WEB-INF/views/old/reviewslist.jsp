<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Places</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Tile</th>
                <th>Description</th>
                <th>Text</th>
                <th>Date</th>
                <th>Task</th>
                <th>User</th>
                <th width="100"></th>
                <th width="100"></th>
                <th width="160"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reviews}" var="review">
                <tr>
                    <td>${review.title}</td>
                    <td>${review.shortDescription}</td>
                    <td>${review.text}</td>
                    <td>${review.date}</td>
                    <td>${review.task.title}</td>
                    <td>${review.creator.ssoId}</td>
                    <td><a href="<c:url value='/reviews-edit-${review.title}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/reviews-delete-${review.title}' />" class="btn btn-danger custom-width">delete</a></td>
                    <td>
                        <a href="<c:url value='/reviewsComment-create-${review.id}' />" class="btn btn-warning custom-width">add comment</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
