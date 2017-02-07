<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Apartament List</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="Apartament List">

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">

</head>
<body>

<div class="container-fluid">
    <%@include file="authheaderUsers.jsp" %>
    <div class="row">
        <div class="col-md-12">
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Link</th>
                    <th>Title</th>
                    <th>Raion</th>
                    <th>Name</th>
                    <th>Time update</th>
                    <th>Price</th>
                    <th>Komnat</th>
                    <th>Telephon</th>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                        <th width="100"></th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${apartaments}" var="apartament">
                    <tr>
                        <td word-wrap: normal;>${apartament.dataId}</td>
                        <td word-wrap: normal;><a>${apartament.link}</a></td>
                        <td word-wrap: normal;>${apartament.title}</td>
                        <td word-wrap: normal;>${apartament.raion}</td>
                        <td word-wrap: normal;>${apartament.nameBoss}</td>
                        <td word-wrap: normal;>${apartament.addTime}</td>
                        <td word-wrap: normal;>${apartament.price}</td>
                        <td word-wrap: normal;>${apartament.kollKomnat}</td>
                        <td word-wrap: normal;>${apartament.telephon}</td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='/edit-apartament-${apartament.dataId}' />" class="btn btn-success custom-width">edit</a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='/delete-apartament-${apartament.dataId}' />" class="btn btn-danger custom-width">delete</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12">
            <sec:authorize access="hasRole('ADMIN')">
                <div class="well">
                    <a href="<c:url value='/newapartament' />">Add New Apartament</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>

<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/scripts.js"></script>
</body>
</html>