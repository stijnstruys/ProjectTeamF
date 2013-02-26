<%--
  Created by IntelliJ IDEA.
  User: Jeroen
  Date: 7/02/13
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.UserProfile"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../General/header.jsp"/>

<section id="content">
    <h2><spring:message code="label.UserProfile"/></h2>
    <h4><spring:message code="label.General"/></h4>
        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.username"/></label></div>
            <div class="span3">
                <label class="checkbox" >${user.username} </label>
            </div>

        </div>

        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.firstname"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.firstName} </label>
            </div>
            <div class="span2"><label class="profile_right"><spring:message code="label.lastname"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.lastName} </label>
            </div>
        </div>

        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.dateOfBirth"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl"><fmt:formatDate value="${user.dateOfBirth}" pattern="dd/MM/yyyy"/></label>
            </div>
        </div>

        <h4>Contact</h4>
        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.email"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.email} </label>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.telephone"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.telephone} </label>
            </div>
        </div>

        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.city"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.city} </label>
            </div>
            <div class="span2"><label class="profile_right"><spring:message code="label.zipcode"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.zipcode} </label>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span2" ><label class="profile_right"><spring:message code="label.street"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.street} </label>
            </div>
            <div class="span2"><label class="profile_right"><spring:message code="label.number"/></label></div>
            <div class="span3">
                <label class="checkbox profile_lbl" >${user.number} </label>
            </div>
        </div>
</section>

<jsp:include page="../General/footer.jsp"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
</body>
</html>