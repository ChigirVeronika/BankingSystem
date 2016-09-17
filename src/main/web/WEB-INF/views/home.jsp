<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div>
    <div class="generic-container">
        <div>
            ${success}
        </div>
        <div class="well">
            <nav>
                <ul>
                    <li><a href="<c:url value='/list' />">Show User List</a></li>
                    <%--<!--<li><a href="<c:url value='/create-user' />">Add user</a></li>-->--%>
                    <li><a href="<c:url value='/create-deposit' />">Add deposit</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>
</body>

</html>