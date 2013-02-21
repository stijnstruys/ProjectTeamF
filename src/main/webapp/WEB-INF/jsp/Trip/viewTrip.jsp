<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
  Date: 7/02/13
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.ViewTrip"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to
    improve your experience.</p>
<![endif]-->
<jsp:include page="../General/header.jsp"/>

<section id="content">
    <style>
        #content {
            background: ${trip.bgcolor};
            color: ${trip.fontcolorContent};
        }

        h2 {
            color: ${trip.fontcolorTitle};
        }

        h3 {
            color: ${trip.fontcolorTitle};
            text-align: center;
        }

    </style>

    <h2>${trip.tripName}</h2>

    <h3>${trip.notification}</h3>

    <spring:message code="label.startLocation"/>: ${trip.startLocation} <br/>
    <spring:message code="label.organiser"/>: ${trip.organiser.firstName} ${trip.organiser.lastName}<br/>
    <spring:message code="label.startDate"/>: <fmt:formatDate value="${trip.startDate}" pattern="dd-MM-yyyy" /> <br/>
    <spring:message code="label.endDate"/>: <fmt:formatDate value="${trip.endDate}" pattern="dd-MM-yyyy" /> <br/>
    <spring:message code="label.tripDescription"/>: ${trip.tripDescription} <br/>
    <c:if test="${registered != true}">
        <form action="join/${trip.tripId}.html">
            <input type="submit" value="<spring:message code="label.join"/>">
        </form>
    </c:if>
    <c:if test="${registered == true}">
        <form action="leave/${trip.tripId}.html">
            <input type="submit" value="<spring:message code="label.leaveTrip"/>">
        </form>
    </c:if>

    <h2>Deelnemers</h2>

    <c:if test="${!empty deelnemers}">
        <table class="data">
            <tr>
                <th><spring:message code="label.name"/></th>
            </tr>
            <c:forEach items="${deelnemers}" var="user">
                <tr>
                    <td>${user.firstName} ${user.lastName} </a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
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