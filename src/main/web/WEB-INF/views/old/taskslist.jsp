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
                <th>Created date</th>
                <th>Status</th>
                <th>Changed date</th>
                <th>User</th>
                <th>Place</th>
                <th width="100"></th>
                <th width="100"></th>
                <th width="160"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.title}</td>
                    <td>${task.description}</td>
                    <td>${task.dateCreated}</td>
                    <td>${task.status}</td>
                    <td>${task.dateChanged}</td>
                    <td>${task.creator.ssoId}</td>
                    <td>${task.place.name}</td>
                    <td><a href="<c:url value='/tasks-edit-${task.title}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/tasks-delete-${task.title}' />" class="btn btn-danger custom-width">delete</a></td>
                    <td>
                        <a href="<c:url value='/reviews-create-${task.title}' />" class="btn btn-warning custom-width">create review</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
