<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Error</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div class="generic-container">
    <div class="well">
        Error occurs!
    </div>
    <div class="well">
        <nav>
            <ul>
                <li><a href="<c:url value='/list' />">Show User List</a></li>
                <li><a href="<c:url value='/create-user' />">Add user</a></li>
                <li><a href="<c:url value='/home' />">Home</a></li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
