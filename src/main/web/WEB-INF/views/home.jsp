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
<div>
    <div class="generic-container">
        <div>
            ${success}
        </div>
        <%--<div class="well">--%>
            <%--<nav>--%>
                <%--<ul>--%>
                    <%--<li><a href="<c:url value='/list' />">User List</a></li>--%>
                    <%--<li><a href="<c:url value='/deposit-list' />">Deposit List</a></li>--%>
                    <%--<li><a href="<c:url value='/bill-list' />">All Users Deposits</a></li>--%>
                    <%--<li><a href="<c:url value='/bank' />">Bank Bills</a></li>--%>
                    <%--&lt;%&ndash;<li><a href="<c:url value='/create-user' />">Add user</a></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li><a href="<c:url value='/create-deposit' />">Add deposit</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</nav>--%>
        <%--</div>--%>
        <jsp:include page="layout/menu.jsp"/>
    </div>

</div>
</body>

</html>