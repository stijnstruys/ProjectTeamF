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
    <title><spring:message code="label.TripSearchResult"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
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
<%
    int count = 0;
    int pagina = 0;
%>
<section id="content">
    <section class="tripPages">
        <h2><spring:message code="label.TripSearchResult"/></h2>

        <c:if test="${!empty tripSearchList}">
            <h3><spring:message code="label.FoundOnTripName"/> <%= request.getParameter("searchInput")%>
            </h3>
            <ul class="trip_list">
                <c:forEach items="${tripSearchList}" var="trip">
                    <div class="trip_details trip_pagina_<%=pagina%>_content">
                        <div class="trip_name"><a class="trip_name"
                                                  href="../trip/${trip.tripId}.html">${trip.tripName}</a>
                        </div>
                        <div class="trip_description">${trip.tripDescription}</div>

                        <div class="trip_extra">
                            <div class="trip_datums"><fmt:formatDate value="${trip.startDate}" pattern="dd/MM/yyyy"/> ~
                                <fmt:formatDate value="${trip.endDate}" pattern="dd/MM/yyyy"/></div>
                            <div class="trip_location"></b><spring:message code="label.startLocation"/>: <span
                                    class="trip_detail_general">${trip.startLocation}</span></div>
                        </div>

                    </div>
                    <%
                        count++;
                        if (count == 6) {
                            count = 0;
                            pagina++;
                        }
                    %>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${!empty tripSearchCategories}">
            <h3><spring:message code="label.FoundOnTripCategory"/> <%= request.getParameter("searchInput") %>
            </h3>
            <ul class="trip_list">
                <c:forEach items="${tripSearchCategories}" var="trip">
                    <div class="trip_details trip_pagina_<%=pagina%>_content">
                        <div class="trip_name"><a class="trip_name"
                                                  href="../trip/${trip.tripId}.html">${trip.tripName}</a>
                        </div>
                        <div class="trip_description">${trip.tripDescription}</div>

                        <div class="trip_extra">
                            <div class="trip_datums"><fmt:formatDate value="${trip.startDate}" pattern="dd/MM/yyyy"/> ~
                                <fmt:formatDate value="${trip.endDate}" pattern="dd/MM/yyyy"/></div>
                            <div class="trip_location"></b><spring:message code="label.startLocation"/>: <span
                                    class="trip_detail_general">${trip.startLocation}</span></div>
                        </div>

                    </div>
                    <%
                        count++;
                        if (count == 6) {
                            count = 0;
                            pagina++;
                        }
                    %>
                </c:forEach>
            </ul>
        </c:if>
        <div class="float_fix"></div>
        <div class="pagination">
            <ul>
                <%-- <li id="trips_prev"><a href="#">&larr; Previous</a></li>  --%>
                <%
                    for (int i = 0; i <= pagina; i++) {
                %>
                <li><a href="#" class="trip_pagina" id="trip_pagina_<%=i %>"><%=(i + 1)%>
                </a></li>
                <%
                    }
                %>
                <%-- <li id="trips_next"><a href="#" id="trips_next_a">Next &rarr;</a></li>  --%>
            </ul>
        </div>
        <div class="float_fix"></div>

    </section>
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