<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <script src="../js/registrationValidation.js"></script>

    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>

<body>

<div class="generic-container">
    <div class="well">
        <a href="<c:url value='/list' />">User list</a>
        <a href="<c:url value='/home' />">Home</a>
    </div>
    <div class="well lead">User</div>
    <form:form method="POST" onsubmit="return registrationFormValidation();"  modelAttribute="user" class="form-horizontal">
        <form:input type="hidden" path="id" id="id" />

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name*</label>
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
                <label class="col-md-3 control-lable" for="middleName">Middle Name*</label>
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
                <label class="col-md-3 control-lable" for="lastName">Last Name*</label>
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
                <label class="col-md-3 control-lable" for="birthday">Person Birthday*</label>
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
                    <label class="col-md-3 control-lable" for="gender">Gender*</label>
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
                <label class="col-md-3 control-lable" for="passportSeriesAndNumber">Passport Series And Number*</label>
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
                <label class="col-md-3 control-lable" for="whomGranted">Whom Granted*</label>
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
                <label class="col-md-3 control-lable" for="grantedDate">Passport Granted Date*</label>
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
                <label class="col-md-3 control-lable" for="idNumber">ID Number*</label>
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
                <label class="col-md-3 control-lable" for="birthPlace">Birth Place*</label>
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
                <label class="col-md-3 control-lable" for="accommodationCity">Accommodation City*</label>
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
                <label class="col-md-3 control-lable" for="accommodationAddress">Accommodation Address*</label>
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
                <label class="col-md-3 control-lable" for="homePhone">Home Phone</label>
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
                <label class="col-md-3 control-lable" for="cellPhone">Cell Phone</label>
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
                <label class="col-md-3 control-lable" for="email">Email</label>
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
                <label class="col-md-3 control-lable" for="workPlace">Work Place</label>
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
                <label class="col-md-3 control-lable" for="position">Position</label>
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
                <label class="col-md-3 control-lable" for="registrationCity">Registration City*</label>
                <div class="col-md-7">
                    <form:select path="registrationCity" id="registrationCity" class="form-control input-sm" >
                        <form:option value="1" label="Minsk" />
                        <form:option value="2" label="Grodno" />
                        <form:option value="3" label="Brest" />
                        <form:option value="4" label="Gomel" />
                        <form:option value="5" label="Vitebsk" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="registrationCity" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="maritalStatus">Marital Status*</label>
                <div class="col-md-7">
                    <form:select path="maritalStatus" id="maritalStatus" class="form-control input-sm" >
                        <form:option value="1" label="not married" />
                        <form:option value="2" label="married" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="maritalStatus" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="citizenship">Citizenship*</label>
                <div class="col-md-7">
                    <form:select path="citizenship" id="citizenship" class="form-control input-sm" >
                        <form:option value="1" label="belarussian" />
                        <form:option value="2" label="rusiian" />
                        <form:option value="3" label="british" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="citizenship" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="disability">Disability*</label>
                <div class="col-md-7">
                    <form:select path="disability" id="disability" class="form-control input-sm" >
                        <form:option value="1" label="none" />
                        <form:option value="2" label="some" />
                        <form:option value="3" label="another" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="disability" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="pensioner">Pensioner</label>
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
                <label class="col-md-3 control-lable" for="monthIncome">Month Income</label>
                <div class="col-md-7">
                    <form:input type="number" min="0" path="monthIncome" id="monthIncome" class="form-control input-sm" />
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
