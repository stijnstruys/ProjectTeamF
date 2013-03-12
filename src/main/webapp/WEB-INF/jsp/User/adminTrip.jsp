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
    <title><spring:message code="label.updateTrip"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/plugins/farbtastic.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
    <script src="../js/equipment.js"></script>
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
%>
<section id="content">
<section class="tripPages">
<style>
    #content {
        background: ${trip.bgcolor};
        color: ${trip.fontcolorContent};
    }

    h2 {
        color: ${trip.fontcolorTitle};
    }
</style>

<a href="deleteTrip/${trip.tripId}.html" class="btn btn-danger btn_green_right"><spring:message
        code="label.deleteTrip"/></a>

<h2><spring:message code="label.updateTrip"/></h2>

<form:form id="viewTripForm" method="post" action="updateTrip.html" commandName="trip" class="form-horizontal">
    <form:hidden id="hiddenTripID" path="tripId"/>

    <legend><spring:message code="label.General"/></legend>
    <a href="/ProjectTeamF-1.0/StopPlaats/${trip.tripId}.html" class="btn btn-success float_right manageBtn"
       id="ManageStoppingPoints"><spring:message code="label.ManageStoppingPoints"/></a>

    <div class="control-group">
        <form:label id="labelTripN" class="control-label" path="tripName"><spring:message
                code="label.tripName"/></form:label>
        <div class="controls">
            <form:input type="text" id="TripN" path="tripName"/>
        </div>
    </div>
    <a href="/ProjectTeamF-1.0/TripParticipants/${trip.tripId}.html" class="btn btn-success float_right manageBtn"
       id="ManageParticipants"><spring:message code="label.ManageParticipants"/></a>

    <div class="control-group">
        <form:label id="labelTripLoc" class="control-label" path="startLocation"><spring:message
                code="label.startLocation"/></form:label>
        <div class="controls">
            <form:input type="text" id="TripLoc" path="startLocation"/>
        </div>
    </div>
    <a href="/ProjectTeamF-1.0/TripCategorie/${trip.tripId}.html" class="btn btn-success float_right manageBtn"
       id="ManageCategories" class="btn_green_left"><spring:message code="label.ManageCategories"/></a>

    <div class="control-group">
        <form:label id="labelTripDescr" class="control-label" path="tripDescription"><spring:message
                code="label.tripDescription"/></form:label>
        <div class="controls">
            <form:input type="text" id="TripDescr" path="tripDescription"/>
        </div>
    </div>
    <a href="/ProjectTeamF-1.0/BroadcastMessage/${trip.tripId}.html" class="btn btn-success float_right manageBtn"
       id="BroadcastMessages"><spring:message code="label.BroadcastMessages"/></a>
    <div class="control-group">
            <form:label id="labelTripNotificatie" class="control-label" path="notification"><spring:message
                    code="label.TripNotificatie"/></form:label>
            <div class="controls">
                <form:input type="text" id="TripNotificatie" path="notification"/>
            </div>
        </div>
    <a href="/ProjectTeamF-1.0/kost/adminKostTrip${trip.tripId}.html" class="btn btn-success float_right manageBtn"
       id="KostOverview"><spring:message code="label.CostOverview"/></a>
    <c:if test="${3 != trip.tripType.tripTypeId}">
        <div class="control-group">
            <form:label id="labelTripStartD" class="control-label" path="startDate"><spring:message
                    code="label.startDate"/></form:label>
            <div class="controls">
                <form:input id="TripStartD" class="datepicker" readonly="true" style="cursor: text;" path="startDate"
                            type="text"
                            value="${1900 + trip.startDate.year}/${1 + trip.startDate.month}/${trip.startDate.date}"/>
            </div>
        </div>
    </c:if>
    <c:if test="${3 != trip.tripType.tripTypeId}">
        <div class="control-group">
            <form:label id="labelTripEndD" class="control-label" path="endDate"><spring:message
                    code="label.endDate"/></form:label>
            <div class="controls">
                <form:input id="TripEndD" class="datepicker" readonly="true" style="cursor: text;" path="endDate"
                            type="text"
                            value="${1900 + trip.endDate.year}/${1 + trip.endDate.month}/${trip.endDate.date}"/>
            </div>
        </div>
    </c:if>


    <div class="control-group">
        <div class="controls">
            <label class="checkbox">
                <form:checkbox path="visible"/><spring:message code="label.tripVisible"/>
            </label>

        </div>
    </div>

    <legend><spring:message code="label.equipment"/></legend>
    <div class="control-group">
        <form:label class="control-label" path="equipment"><spring:message code="label.equipment"/></form:label>
        <div class="controls">
            <input type="text" id="equipment-input"/>
            <span class="help-inline url" id="add_equipment"><spring:message code="label.tripAdd"/></span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <form:select multiple="multiple" path="equipment" id="trip_equipment">
                <c:forEach items="${trip.equipment}" var="equipmentPiece">
                    <form:option value="${equipmentPiece}"> ${equipmentPiece}</form:option>
                </c:forEach>
            </form:select>
            <span class="help-inline url" id="remove_equipment"><spring:message code="label.removeSelected"/></span>
        </div>
    </div>

    <legend><spring:message code="label.Colors"/></legend>

    <div id="picker" style="float: right;"></div>
    <div id="pickerdivs">
        <div class="control-group">
            <label class="form-item control-label"><spring:message code="label.Background"/> </label>

            <div class="controls">
                <form:input type="text" name="color1" path="bgcolor" class="colorpicker" id="color1" readonly="true"/>
            </div>
        </div>
        <div class="control-group">
            <label class="form-item control-label"><spring:message code="label.FontTitle"/></label>

            <div class="controls">
                <form:input type="text" name="color2" path="fontcolorContent" class="colorpicker" id="color2"
                            readonly="true"/>
            </div>
        </div>
        <div class="control-group">
            <label class="form-item control-label"><spring:message code="label.FontContent"/></label>

            <div class="controls">
                <form:input type="text" name="color3" path="fontcolorTitle" class="colorpicker" id="color3"
                            readonly="true"/>
            </div>
        </div>
    </div>

    <div id="onder"></div>


</form:form>
<button class="btn" id="updateTrip"><spring:message code="label.updateTrip"/></button>


<div id="dialog-message" title="<spring:message code="label.NotificationMailTitle"/>">

    <fieldset>
        <label><spring:message code="label.NotificationMailQuestion"/></label>
        <label for="dialog-message" id="messageOrg"><spring:message
                code="label.NotificationMailOrganiserMessage"/> ${trip.organiser.firstName} ${trip.organiser.lastName}</label>
        <textarea type="text" name="message" id="Message" value=""
                  class="text ui-widget-content ui-corner-all"><spring:message
                code="label.NotificationMailNoMessage"/></textarea>
        <label for="changes" id="followingChanges"><spring:message
                code="label.NotificationMailChangesOccured"/></label>

        <div id="changes">
            <table id="messageTable" style="min-width:500px">
                <tr class="messageRow" id="messageRowN">
                    <td><label id="tripNmessage"></label></td>
                    <td><label id="tripNold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripNchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripNnew" class="text ui-widget-content ui-corner-all"/></td>
                </tr>
                <tr class="messageRow" id="messageRowD">
                    <td><label id="tripDmessage"></label></td>
                    <td><label id="tripDold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripDchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripDnew" class="text ui-widget-content ui-corner-all"/></td>
                </tr>
                <tr class="messageRow" id="messageRowStartD">
                    <td><label id="tripStartDmessage"></label></td>
                    <td><label id="tripStartDold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripStartDchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripStartDnew" class="text ui-widget-content ui-corner-all"/>
                    </td>
                </tr>
                <tr class="messageRow" id="messageRowEndD">
                    <td><label id="tripEndDmessage"></label></td>
                    <td><label id="tripEndDold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripEndDchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripEndDnew" class="text ui-widget-content ui-corner-all"/></td>
                </tr>
                <tr class="messageRow" id="messageRowNot">
                    <td><label id="tripNotmessage"></label></td>
                    <td><label id="tripNotold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripNotchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripNotnew" class="text ui-widget-content ui-corner-all"/></td>
                </tr>
                <tr class="messageRow" id="messageRowLoc">
                    <td><label id="tripLocmessage"></label></td>
                    <td><label id="tripLocold" class="text ui-widget-content ui-corner-all"/></td>
                    <td><label id="tripLocchange" class="changedTo"><spring:message
                            code="label.ChangedTo"/></label></td>
                    <td><label id="tripLocnew" class="text ui-widget-content ui-corner-all"/></td>
                </tr>
            </table>
        </div>
        <table>
            <tr>
                <td><p id="viewTheTrip"><spring:message
                        code="label.viewTheTrip"/> <a id="viewTheTripLink"
                                                      href="http://localhost:8080/ProjectTeamF-1.0/trip/${trip.tripId}.html">${trip.tripName}</a>!
                </p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="btn" id="sendMail"><spring:message code="label.sendMail"/></button>
                    <button class="btn" id="skip"><spring:message code="label.skipMail"/></button>
                </td>

            </tr>
        </table>

    </fieldset>

</div>
</section>
</section>
<jsp:include page="../General/footer.jsp"/>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins/farbtastic.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/plugins/colorpicker.js"></script>
</body>
</html>