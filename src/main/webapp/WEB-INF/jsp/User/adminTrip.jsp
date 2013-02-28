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

        <h2><spring:message code="label.updateTrip"/></h2>

        <form:form id="viewTripForm" method="post" action="updateTrip.html" commandName="trip">

            <table id="adminTripTable">
                <tr>
                    <td><form:hidden id="hiddenTripID" path="tripId"/></td>
                </tr>
                <tr>
                    <td><form:label id="labelTripN" path="tripName"><spring:message
                            code="label.tripName"/></form:label></td>
                    <td><form:input id="TripN" path="tripName"/></td>
                    <td><form:label id="labelTripLoc" path="startLocation"><spring:message
                            code="label.startLocation"/></form:label></td>
                    <td><form:input id="TripLoc" path="startLocation"/></td>
                </tr>
                <tr>
                    <td><form:label id="labelTripStartD" path="startDate"><spring:message
                            code="label.startDate"/></form:label></td>
                    <td><form:input id="TripStartD" class="datepicker" readonly="true" style="cursor: text;"
                                    path="startDate"
                                    value="${1900 + trip.startDate.year}/${1 + trip.startDate.month}/${trip.startDate.date}"/></td>
                    <td><form:label id="labelTripEndD" path="endDate"><spring:message
                            code="label.endDate"/></form:label></td>
                    <td><form:input id="TripEndD" class="datepicker" readonly="true" style="cursor: text;"
                                    path="endDate"
                                    value="${1900 + trip.endDate.year}/${1 + trip.endDate.month}/${trip.endDate.date}"/></td>
                </tr>
                <tr>
                    <td><form:label id="labelTripDescr" path="tripDescription"><spring:message
                            code="label.tripDescription"/></form:label></td>
                    <td rowspan="2"><form:textarea id="TripDescr" path="tripDescription"/></td>
                    <td><form:label id="labelTripNotificatie" path="notification"><spring:message
                            code="label.TripNotificatie"/></form:label></td>
                    <td rowspan="2"><form:textarea id="TripNotificatie" path="notification"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><form:label id="labelTripEquipment" path="equipment"><spring:message
                            code="label.equipment"/></form:label></td>
                    <c:if test="${!empty trip.equipment}">

                    <c:forEach items="${trip.equipment}" var="equipmentPiece">
                            <%
                        count++;
                    %>
                <tr id="equipment<%=count%>">
                    <td>
                        <input type="text" value="${equipmentPiece}" name="equipment"/>
                        <button class="btn" type="button" onclick="removeEquipment('equipment<%=count%>')">X</button>
                    </td>
                </tr>
                </c:forEach>
                </c:if>
                </tr>
                <tr>
                    <td>
                        <button id="newEquip" class="btn" type="button" onclick="addEquipment()">New</button>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="form-item"><spring:message
                                                    code="label.Background"/></label><form:input type="text" name="color1" path="bgcolor"
                                                                                class="colorpicker" id="color1"/>
                        <label class="form-item"><spring:message
                                                    code="label.FontTitle"/></label><form:input type="text" name="color2"
                                                                                path="fontcolorContent"
                                                                                class="colorpicker" id="color2"/>
                        <label class="form-item"><spring:message
                                                    code="label.FontContent"/></label><form:input type="text" name="color3"
                                                                                  path="fontcolorTitle"
                                                                                  class="colorpicker" id="color3"/>
                    </td>
                    <td>
                        <div id="picker" style="float: right;"></div>
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </form:form>


        <table>
            <tr>
                <td>
                    <h3><spring:message code="label.Manage"/></h3>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn" id="ManageStoppingPoints"
                            onClick="location.href='/ProjectTeamF-1.0/StopPlaats/${trip.tripId}.html'"><spring:message
                            code="label.ManageStoppingPoints"/></button>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn" id="ManageParticipants"
                            onClick="location.href='/ProjectTeamF-1.0/TripParticipants/${trip.tripId}.html'">
                        <spring:message
                                code="label.ManageParticipants"/></button>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn" id="ManageCategories"
                            onClick="location.href='/ProjectTeamF-1.0/TripCategorie/${trip.tripId}.html'">
                        <spring:message
                                code="label.ManageCategories"/></button>
                </td>
            </tr>
        </table>

        <button class="btn" id="updateTrip"><spring:message code="label.updateTrip"/></button>
        <button class="btn" onclick="location.href='deleteTrip/${trip.tripId}.html'"><spring:message
                code="label.deleteTrip"/></button>

        <div id="dialog-message" title="<spring:message code="label.NotificationMailTitle"/>">
            <form>
                <fieldset>
                    <label><spring:message code="label.NotificationMailQuestion"/></label>
                    <label for="dialog-message"><spring:message code="label.NotificationMailOrganiserMessage"/></label>
                    <textarea type="text" name="message" id="Message" value=""
                              class="text ui-widget-content ui-corner-all"><spring:message
                            code="label.NotificationMailNoMessage"/></textarea>
                    <label for="changes"><spring:message code="label.NotificationMailChangesOccured"/></label>

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
                            <tr class="messageRow" id="messageRowOrg">
                                <td><label id="tripOrgmessage"></label></td>
                                <td><label id="tripOrgold" class="text ui-widget-content ui-corner-all"/></td>
                                <td><label id="tripOrgchange" class="changedTo"><spring:message
                                        code="label.ChangedTo"/></label></td>
                                <td><label id="tripOrgnew" class="text ui-widget-content ui-corner-all"/></td>
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
                </fieldset>
            </form>
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