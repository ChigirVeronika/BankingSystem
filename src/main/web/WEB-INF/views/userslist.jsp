<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
	<div class="generic-container-add">
		<div class="well">
			<nav>
				<ul>
					<li><a href="<c:url value='/create-user' />">Add user</a></li>
					<li><a href="<c:url value='/home' />">Home</a></li>
				</ul>
			</nav>
		</div>
		<div>
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users</span></div>
			<table>
	    		<thead>
		      		<tr>
						<th>Last Name</th>
				        <th>First Name</th>
				        <th>Middle Name</th>
				        <th>Birthday</th>
				        <th>Gender</th>
						<th>Passport</th>
						<th>Whom Granted</th>
						<th>Granted Date</th>
						<th>Id number</th>
						<th>Birthplace</th>
						<th>Accommodation city</th>
						<th>Accommodation address</th>
						<th>Home phone</th>
						<th>Cell phone</th>
				        <th>Email</th>
				        <th>Work Place</th>
				        <th>Position</th>
				        <th>Registration city</th>
				        <th>Marital status</th>
				        <th>Citizenship</th>
				        <th>Disability</th>
				        <th>Pensioner</th>
				        <th>Month Income</th>
				        <th width="200"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.lastName}</td>
						<td>${user.firstName}</td>
						<td>${user.middleName}</td>
						<td>${user.birthday}</td>
						<td>${user.gender}</td>
						<td>${user.passportSeries}${user.passportNumber}</td>
						<td>${user.whomGranted}</td>
						<td>${user.grantedDate}</td>
						<td>${user.idNumber}</td>
						<td>${user.birthPlace}</td>
						<td>${user.accommodationCity.getName()}</td>
						<td>${user.accommodationAddress}</td>
						<td>${user.homePhone}</td>
						<td>${user.cellPhone}</td>
						<td>${user.email}</td>
						<td>${user.workPlace}</td>
						<td>${user.position}</td>
						<td>${user.registrationCity.getName()}</td>
						<td>${user.maritalStatus.getType()}</td>
						<td>${user.citizenship.getName()}</td>
						<td>${user.disability.getType()}</td>
						<td>${user.pensioner}</td>
						<td>${user.monthIncome}</td>
						<td><a href="<c:url value='/create-deposit-${user.id}' />" class="btn btn-warning custom-width">deposit</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>

   	</div>
</body>
</html>