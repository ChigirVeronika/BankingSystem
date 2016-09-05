<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Place</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div>
    <div>Place</div>
    <form:form method="POST" action="" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div>
            <div>
                <label for="name">Name</label>
                <div>
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="name" id="name" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="name" id="name"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="description">Description</label>
                <div>
                    <form:input type="text" path="description" id="description"/>
                    <div class="has-error">
                        <form:errors path="description" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="city">City</label>
                <div>
                    <form:input type="text" path="city" id="city"/>
                    <div class="has-error">
                        <form:errors path="city" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="street">Street</label>
                <div>
                    <form:input type="text" path="street" id="street"/>
                    <div class="has-error">
                        <form:errors path="street" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="house">House</label>
                <div>
                    <form:input type="text" path="house" id="house"/>
                    <div class="has-error">
                        <form:errors path="house" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="email">Email</label>
                <div>
                    <form:input type="text" path="email" id="email"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <label for="type">Types</label>
                <div>
                    <form:input type="text" path="type" id="type"/>
                    <div class="has-error">
                        <form:errors path="type" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div>
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update"/> or <a href="<c:url value='/placeslist' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add place"/> or <a href="<c:url value='/placeslist' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
