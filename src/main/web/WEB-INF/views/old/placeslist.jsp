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
                <th>Name</th>
                <th>Description</th>
                <th>City</th>
                <th>Street</th>
                <th>House</th>
                <th>Email</th>
                <th>Type</th>
                <th width="100"></th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.name}</td>
                    <td>${place.description}</td>
                    <td>${place.city}</td>
                    <td>${place.street}</td>
                    <td>${place.house}</td>
                    <td>${place.email}</td>
                    <td>${place.type}</td>
                    <td><a href="<c:url value='/places-edit-${place.name}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/places-delete-${place.name}' />" class="btn btn-danger custom-width">delete</a></td>
                    <td>
                        <a href="<c:url value='/tasks-create-${place.name}' />" class="btn btn-warning custom-width">create task</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/places-create' />">Add place</a>
    </div>
</div>
</body>
</html>
