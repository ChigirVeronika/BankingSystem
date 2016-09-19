<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <div class="panel-heading"><span class="lead">Banking System</span></div>
    <nav>
        <ul>
            <li><a href="<c:url value='/home' />">Home</a></li>
            <li><a href="<c:url value='/list' />">User List</a></li>
            <li><a href="<c:url value='/deposit-list' />">Deposit List</a></li>
            <li><a href="<c:url value='/credit-list' />">Credit List</a></li>
            <li><a href="<c:url value='/bill-list' />">All Users Deposits</a></li>
            <li><a href="<c:url value='/bill-list2' />">All Users Credits</a></li>
            <li><a href="<c:url value='/bank' />">Bank Bills</a></li>
            <li><a href="<c:url value='/atm' />">ATM</a></li>
        </ul>
    </nav>
</div>
