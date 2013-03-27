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
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>
<body>
<div id="fb-root"></div>
<%--<script></script>--%>
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

<section class="tripPages">

    <input class="hidden" id="getTripId" hidden value="${trip.tripId}"/>
    <c:if test="${registered != true}">
        <a href="join/${trip.tripId}.html" class="btn btn-success btn_green_right"><spring:message
                code="label.join"/></a>
    </c:if>
    <c:if test="${registered == true}">
        <a href="leave/${trip.tripId}.html" class="btn btn-success btn_green_right"><spring:message
                code="label.leaveTrip"/></a>
        <a href="../kost/kostenPerTrip${trip.tripId}.html" class="btn btn-success btn_green_right"><spring:message
                code="label.ManageCosts"/></a>
    </c:if>

    <c:if test="${registered == true}">
    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tab1" data-toggle="tab"><spring:message
                    code="label.overview"></spring:message></a></li>
            <li id="chat-li"><a href="#tab2" id="gotochat" data-toggle="tab"><spring:message
                    code="label.chat"></spring:message></a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tab1">

                <p>
                    </c:if>

                <h2>${trip.tripName}</h2>
                ${trip.tripDescription}
                </br></br>

                <legend><spring:message code="label.General"/></legend>
                <div class="row-fluid">
                    <div class="span2"><label class="profile_right"><spring:message
                            code="label.startLocation"/></label></div>
                    <div class="span3">
                        <label class="checkbox profile_lbl">${user.startLocation} </label>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span2"><label class="profile_right"><spring:message code="label.organiser"/></label>
                    </div>
                    <div class="span3">
                        <label class="checkbox profile_lbl"><a href="/ProjectTeamF-1.0/user/profile-${trip.organiser.userID}.html">${trip.organiser.username}</a></label>
                    </div>
                </div>
                <c:if test="${!(trip.tripType == 'Los')}">
                <div class="row-fluid">
                    <div class="span2"><label class="profile_right"><spring:message code="label.startDate"/></label>
                    </div>
                    <div class="span3"><label class="checkbox profile_lbl"><fmt:formatDate value="${trip.startDate}"
                                                                                           pattern="dd/MM/yyyy"/></label>
                    </div>
                    <div class="span2"><label class="profile_right"><spring:message code="label.endDate"/></label>
                    </div>
                    <div class="span3"><label class="checkbox profile_lbl"><fmt:formatDate value="${trip.endDate}"
                                                                                           pattern="dd/MM/yyyy"/></label>
                    </div>
                </div>
                </c:if>
                <legend><spring:message code="label.equipment"/></legend>
                <div class="row-fluid">
                    <div class="span2"><label class="profile_right"><spring:message code="label.equipment"/></label>
                    </div>

                    <c:if test="${!empty trip.equipment}">
                        <div class="span3">
                            <label class="checkbox profile_lbl">
                                <c:forEach items="${trip.equipment}" var="value">
                                    ${value} </br>
                                </c:forEach>
                            </label>
                        </div>
                    </c:if>
                </div>

                <legend><spring:message code="label.StoppingPoints"/></legend>
                <c:if test="${!trip.showMap}">
                    <c:if test="${!empty trip.stopPlaatsen}">
                        <table class="table">
                            <thead>
                            <th>#</th>
                            <th><spring:message code="label.StoppingPoint"/></th>
                            <th><spring:message code="label.StoppingPointName"/></th>
                            <th><spring:message code="label.StoppingPointType"/></th>
                            <th><spring:message code="label.StoppingPointInfo"/></th>
                            </thead>

                            <% int count = 1; %>
                            <tbody>
                            <c:forEach items="${trip.stopPlaatsen}" var="stopPlaats">
                                <tr>
                                    <td><%=count%>
                                    </td>
                                    <td>${stopPlaats.adres}</td>
                                    <td>${stopPlaats.naam}</td>
                                    <td>${stopPlaats.type}</td>
                                    <td>${stopPlaats.informatie}</td>
                                </tr>
                                <% count++; %>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </c:if>

                <c:if test="${trip.showMap}">
                    <c:if test="${!empty trip.stopPlaatsen}">
                        <label id="traveltype" class="travelT">${trip.travelType}</label>
                        <div class="float_left stopplaats_overview">
                            <% int count3 = 0; %>
                            <c:forEach items="${trip.stopPlaatsen}" var="stopPlaatsen">
                                <div class="addresses2" id="stopplts_<%=count3%>"> ${stopPlaatsen.adres} </div>
                                <div class="address_info hidden"  id="infowindow<%=count3%>">
                                    <div class="infowindow">
                                        <div class="infowindow_head">${stopPlaatsen.naam}</div>
                                        <div class="infowindow_content">
                                            <b><spring:message code="label.StoppingPointType"/>: </b>${stopPlaatsen.type} </br>
                                            <b><spring:message code="label.StoppingPointInfo"/>: </b>${stopPlaatsen.informatie}</br>
                                            <b><spring:message code="label.address"/>: </b> ${stopPlaatsen.adres}
                                        </div>
                                    </div>
                                </div>
                                <label id="coorLat<%=count3%>" class="coordinatesLat">${stopPlaatsen.coorLat}</label>
                                <label id="coorLng<%=count3%>" class="coordinatesLng">${stopPlaatsen.coorLng}</label>
                                <% count3++;%>
                            </c:forEach>
                        </div>
                    </c:if>
                    <section id="map_stoppingpoints">
                        <div id="map_canvas2"></div>
                    </section>
                </c:if>


                <legend><spring:message code="label.Participants"/></legend>
                <c:if test="${!empty trip.deelnames}">
                    <% int count2 = 1; %>
                    <table class="table">
                        <thead>
                        <th>#</th>
                        <th><spring:message code="label.name"/></th>
                        <th><spring:message code="label.IndividualEquipment"/></th>
                        </thead>
                        <tbody>
                        <c:forEach items="${trip.deelnames}" var="deelname">
                            <td><%=count2++%>
                            </td>
                            <td>
                                <a href="/ProjectTeamF-1.0/user/profile-${deelname.user.userID}.html">${deelname.user.firstName} ${deelname.user.lastName} </a>
                            </td>
                            <td>
                                <c:forEach items="${deelname.equipment}" var="equip">
                                    ${equip} </br>
                                </c:forEach></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${trip.showRoute}">
                    <label id="checkShowRouteSolution" class="showRouteTrue"></label>
                </c:if>
                <div class="fb-twitter">
                    <div class="fb-like"
                         data-href="https://www.facebook.com/pages/Tripplanner-teamf/146815778814080"
                         data-send="true" data-width="450" data-show-faces="true"></div>
                    </br>
                    <a href="https://twitter.com/share" class="twitter-share-button" data-url="https://www.facebook.com/pages/Tripplanner-teamf/146815778814080" data-lang="en" data-hashtags="TripPlannerTeamF"><spring:message
                            code="label.Tweet"/></a>
                </div>
                <c:if test="${registered == true}">
                </p>
            </div>
            <div class="tab-pane" id="tab2">
                <p>

                <div id="chat">
                    <div id="chat-area">

                    </div>
                    <div class="input-append input-prepend" id="chat-apprend">
                        <span class="add-on" id="chat-loading"></span>
                        <input class="input-xxlarge" id="shout-msg" type="text"
                               placeholder='<spring:message code="label.shout-saysomething"></spring:message>'>
                        <button class="btn" id="shout" type="button"><spring:message
                                code="label.shout"></spring:message></button>
                    </div>
                </div>
                </p>
            </div>
        </div>
    </div>
    </c:if>


</section>


</section>
</section>
<jsp:include page="../General/footer.jsp"/>

<!--google maps api-->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<%--<script src="../js/social/FBPlugin.js"></script>--%>
<script src="../js/social/Twitter.js"></script>
<script src="../js/social/FBLogin.js"></script>
<script src="http://connect.facebook.net/nl_NL/all.js#xfbml=1&appId=534896926530393" type="text/javascript"></script>
<script src="../js/mapScripts/mapsView.js"></script>

</body>
</html>