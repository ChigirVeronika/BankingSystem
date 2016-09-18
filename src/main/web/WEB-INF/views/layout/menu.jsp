<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <nav>
        <ul>
            <li><a href="<c:url value='/list' />">Show User List</a></li>
            <li><a href="<c:url value='/home' />">Home</a></li>
            <li><a href="<c:url value='/deposit-list' />">Deposit List</a></li>
            <li><a href="<c:url value='/bill-list' />">Al Users Deposits</a></li>
            <li><a href="<c:url value='/bank' />">Bank Bills</a></li>
        </ul>
    </nav>
</div>
