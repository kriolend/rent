<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Appartament Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%@include file="authheaderUsers.jsp" %>

    <div class="well lead">Appartament Registration Form</div>
    <form:form method="POST" modelAttribute="apartament" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="telephon">Telephon</label>
                <div class="col-md-7">
                    <form:input type="text" path="telephon" id="telephon" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="telephon" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="dataId">Data ID</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="dataId" id="dataId" class="form-control input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="dataId" id="dataId" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="dataId" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="link">Link</label>
                <div class="col-md-7">
                    <form:input type="text" path="link" id="link" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="link" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="raion">Raion</label>
                <div class="col-md-7">
                    <form:input type="text" path="raion" id="raion" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="raion" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="nameBoss">Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="nameBoss" id="nameBoss" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="nameBoss" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="addTime">Time update</label>
                <div class="col-md-7">
                    <form:input type="text" path="addTime" id="addTime" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="addTime" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="price">Price</label>
                <div class="col-md-7">
                    <form:input type="text" path="price" id="price" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="price" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="kollKomnat">Komnat</label>
                <div class="col-md-7">
                    <form:input type="text" path="kollKomnat" id="kollKomnat" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="kollKomnat" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listapartament' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listapartament' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>