<%--
  Created by IntelliJ IDEA.
  User: Stijn
  Date: 6-3-13
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="label.MyKost"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>

<body>
<jsp:include page="../General/header.jsp"/>
<%
    int count = 0;
    int pagina = 0;

%>
<section id="content">
    <section class="tripPages">
        <h2><spring:message code="label.MyKost"/></h2>
        <c:if test="${empty deelnames}">
            <h3><spring:message code="label.NoCosts"/></h3>
        </c:if>
        <c:if test="${!empty deelnames}">
            <ul class="trip_list">
                <c:forEach items="${deelnames}" var="deelname">
                    <div class="trip_details trip_pagina_<%=pagina%>_content">
                        <a href="/ProjectTeamF-1.0/kost/kostenPerTrip${deelname.trip.tripId}.html"
                           class="btn btn-success btn_green_right"><spring:message code="label.ManageCosts"/></a>

                        <div class="trip_name">${deelname.trip.tripName}</div>
                        <div class="trip_description">${deelname.trip.tripDescription}</div>

                        <c:set var="totaal" value="0"></c:set>
                        <c:forEach items="${deelname.kosten}" var="kost">
                            <c:set var="totaal" value="${totaal + kost.prijs}"></c:set>
                        </c:forEach>

                        <div><spring:message code="label.totalCost"/>: € ${totaal}

                        </div>


                    </div>
                    <%
                        count++;
                        if (count == 10) {
                            count = 0;
                            pagina++;
                        }
                    %>
                </c:forEach>
            </ul>
        </c:if>
        <div class="float_fix"></div>
    </section>
</section>
<jsp:include page="../General/footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/social/FBLogin.js"></script>


</body>

</html>

