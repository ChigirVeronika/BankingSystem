<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>

<div class="generic-container">
    <div class="well lead">User</div>
    <form:form method="POST" modelAttribute="user" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="middleName">Middle Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="middleName" id="middleName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="middleName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="birthday">Birthday</label>
                <div class="col-md-7">
                    <form:input type="date" path="birthday" id="birthday" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="birthday" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="gender">Gender</label>
                <div class="col-md-7">
                    <form:radiobutton path="gender" id="gender" value="M"/>Male
                    <form:radiobutton path="gender" id="gender" value="F"/>Female

                    <div class="has-error">
                        <form:errors path="gender" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passportSeriesAndNumber">passportSeriesAndNumber</label>
                <div class="col-md-7">
                    <form:input type="text" path="passportSeriesAndNumber" id="passportSeriesAndNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="passportSeriesAndNumber" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="whomGranted">whomGranted</label>
                <div class="col-md-7">
                    <form:input type="text" path="whomGranted" id="whomGranted" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="whomGranted" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="grantedDate">grantedDate</label>
                <div class="col-md-7">
                    <form:input type="date" path="grantedDate" id="grantedDate" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="grantedDate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="idNumber">idNumber</label>
                <div class="col-md-7">
                    <form:input type="text" path="idNumber" id="idNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="idNumber" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="birthPlace">birthPlace</label>
                <div class="col-md-7">
                    <form:input type="text" path="birthPlace" id="birthPlace" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="birthPlace" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="accommodationCity">accommodationCity</label>
                <div class="col-md-7">

                    <form:select path="accommodationCity" id="accommodationCity" class="form-control input-sm" >
                        <form:option value="1" label="Minsk" />
                        <form:option value="2" label="Grodno" />
                        <form:option value="3" label="Brest" />
                        <form:option value="4" label="Gomel" />
                        <form:option value="5" label="Vitebsk" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="accommodationCity" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="accommodationAddress">accommodationAddress</label>
                <div class="col-md-7">
                    <form:input type="text" path="accommodationAddress" id="accommodationAddress" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="accommodationAddress" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="homePhone">homePhone</label>
                <div class="col-md-7">
                    <form:input type="text" path="homePhone" id="homePhone" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="homePhone" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="cellPhone">cellPhone</label>
                <div class="col-md-7">
                    <form:input type="text" path="cellPhone" id="cellPhone" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="cellPhone" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="workPlace">workPlace</label>
                <div class="col-md-7">
                    <form:input type="text" path="workPlace" id="workPlace" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="workPlace" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="position">position</label>
                <div class="col-md-7">
                    <form:input type="text" path="position" id="position" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="position" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="registrationCity">registrationCity</label>
                <div class="col-md-7">
                    <form:select path="registrationCity" id="registrationCity" class="form-control input-sm" >
                        <form:option value="0" label="Minsk" />
                        <form:option value="1" label="Grodno" />
                        <form:option value="2" label="Brest" />
                        <form:option value="3" label="Gomel" />
                        <form:option value="4" label="Vitebsk" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="registrationCity" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="maritalStatus">maritalStatus</label>
                <div class="col-md-7">
                    <form:select path="maritalStatus" id="maritalStatus" class="form-control input-sm" >
                        <form:option value="0" label="not married" />
                        <form:option value="1" label="married" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="maritalStatus" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="citizenship">citizenship</label>
                <div class="col-md-7">
                    <form:select path="citizenship" id="citizenship" class="form-control input-sm" >
                        <form:option value="0" label="belarussian" />
                        <form:option value="1" label="rusiian" />
                        <form:option value="2" label="british" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="citizenship" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="disability">disability</label>
                <div class="col-md-7">
                    <form:select path="disability" id="disability" class="form-control input-sm" >
                        <form:option value="0" label="none" />
                        <form:option value="1" label="some" />
                        <form:option value="2" label="another" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="disability" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="pensioner">pensioner</label>
                <div class="col-md-7">
                    <form:checkbox path="pensioner" value="pensioner" label="pensioner" />

                    <div class="has-error">
                        <form:errors path="pensioner" id="pensioner" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="monthIncome">monthIncome</label>
                <div class="col-md-7">
                    <form:input type="text" path="monthIncome" id="monthIncome" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="monthIncome" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
