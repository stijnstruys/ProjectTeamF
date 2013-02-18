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
    <title>View trip</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.10.0.custom.css" rel="stylesheet">
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
            color:   ${trip.fontcolorContent};
        }
        h2 {
            color:   ${trip.fontcolorTitle};
        }
    </style>

    <a href="admincp-${trip.tripId}.html" class="btn btn-success" id="trip_detailview_adminbtn">Admin</a>
    <h2>${trip.tripName}</h2>

    <spring:message code="label.startLocation"/>: ${trip.startLocation} </br>
    <spring:message code="label.organiser"/>: ${trip.organiser} </br>
    <spring:message code="label.startDate"/>: ${trip.startDate} </br>
    <spring:message code="label.endDate"/>: ${trip.endDate}   </br></br>
    ${trip.tripDescription}


    <%--
    <form:form id="viewTripForm" method="post" action="update.html" commandName="trip">
        <table>
            <tr>
                <td><form:hidden path="tripId"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripN" path="tripName"><spring:message
                        code="label.tripName"/></form:label></td>
                <td><form:input id="TripN" path="tripName"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripDescr" path="tripDescription"><spring:message
                        code="label.tripDescription"/></form:label></td>
                <td><form:input id="TripDescr" path="tripDescription"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripStartD" path="startDate"><spring:message
                        code="label.startDate"/></form:label></td>
                <td><form:input id="TripStartD" class="datepicker" readonly="true" style="cursor: text;"
                                path="startDate"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripEndD" path="endDate"><spring:message
                        code="label.endDate"/></form:label></td>
                <td><form:input id="TripEndD" class="datepicker" readonly="true" style="cursor: text;"
                                path="endDate"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripOrg" path="organiser"><spring:message
                        code="label.organiser"/></form:label></td>
                <td><form:input id="TripOrg" path="organiser"/></td>
            </tr>
            <tr>
                <td><form:label id="labelTripLoc" path="startLocation"><spring:message
                        code="label.startLocation"/></form:label></td>
                <td><form:input id="TripLoc" path="startLocation"/></td>
            </tr>
        </table>
    </form:form>
    <table>
        <tr>
            <td>
                <h3>Stopplaatsen</h3>
                <c:if test="${!empty trip.stopPlaatsen}">
                    <table class="data">
                        <tr>
                            <th>Adres</th>
                            <th>Vrijgegeven</th>
                            <th>&nbsp;</th>
                        </tr>
                        <c:forEach items="${trip.stopPlaatsen}" var="stopPlaats">
                            <tr>
                                <td>${stopPlaats.adres} </td>
                                <td>${stopPlaats.vrijgegeven} </td>
                                <td>
                                    <a href="/ProjectTeamF-1.0/StopPlaats/update/${stopPlaats.stopPlaatsID}.html">Update</a>
                                </td>
                                <td>
                                    <a href="/ProjectTeamF-1.0/StopPlaats/delete/${stopPlaats.stopPlaatsID}.html">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <form action="/ProjectTeamF-1.0/StopPlaats/${trip.tripId}.html">

                    <input type="submit" value="Add new Stop Place"/>
                </form>
            </td>
            <td></td>
            <td>
                <h3>Categorieën</h3>
                <c:if test="${!empty trip.tripCategorieen}">
                    <table class="data">
                        <tr>
                            <th>Naam</th>
                            <th>&nbsp;</th>
                        </tr>
                        <c:forEach items="${trip.tripCategorieen}" var="tripCategorie">
                            <tr>
                                <td>${tripCategorie.tripCategorieName} </td>
                                <td>
                                    <a href="/ProjectTeamF-1.0/TripCategorie/update/${tripCategorie.tripCategorieId}.html">Update</a>
                                </td>
                                <td>
                                    <a href="/ProjectTeamF-1.0/TripCategorie/delete/${tripCategorie.tripCategorieId}.html">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <form action="/ProjectTeamF-1.0/TripCategorie/${trip.tripId}.html">

                    <input type="submit" value="Add new Trip category"/>
                </form>
            </td>
        </tr>
    </table>
    <button id="updateTrip"><spring:message code="label.updateTrip"/></button>
    <a href="delete/${trip.tripId}.html"><spring:message code="label.deleteTrip"/></a>

    <div id="dialog-message" title="Send notification mail">
        <form>
            <fieldset>
                <label>Send following email to all participants?</label>
                <label for="dialog-message">Organiser message</label>
                <textarea type="text" name="message" id="Message" value=""
                          class="text ui-widget-content ui-corner-all"></textarea>
                <label for="changes">The following changes occured</label>

                <div id="changes"></div>
                <table>
                    <tr class="messageRow" id="messageRowN">
                        <td><label id="tripNmessage" class="messageLabel"></label></td>
                        <td><input id="tripNold" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                        <td><label class="messageLabel"><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripNnew" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                    </tr>
                    <tr class="messageRow" id="messageRowD">
                        <td><label id="tripDmessage" class="messageLabel"></label></td>
                        <td><input id="tripDold" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                        <td><label class="messageLabel"><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripDnew" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                    </tr>
                    <tr class="messageRow" id="messageRowStartD">
                        <td><label id="tripStartDmessage" class="messageLabel"></label></td>
                        <td><input id="tripStartDold" class="text ui-widget-content ui-corner-all" readonly="true"/>
                        </td>
                        <td><label class="messageLabel"><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripStartDnew" class="text ui-widget-content ui-corner-all" readonly="true"/>
                        </td>
                    </tr>
                    <tr class="messageRow" id="messageRowEndD">
                        <td><label id="tripEndDmessage" class="messageLabel"></label></td>
                        <td><input id="tripEndDold" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                        <td><label class="messageLabel"><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripEndDnew" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                    </tr>
                    <tr class="messageRow" id="messageRowOrg">
                        <td><label id="tripOrgmessage"></label></td>
                        <td><input id="tripOrgold" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                        <td><label class="messageLabel"><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripOrgnew" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                    </tr>
                    <tr class="messageRow" id="messageRowLoc">
                        <td><label id="tripLocmessage"></label></td>
                        <td><input id="tripLocold" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                        <td><label><spring:message code="label.ChangedTo"/></label></td>
                        <td><input id="tripLocnew" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                    </tr>

                </table>
            </fieldset>
        </form>
    </div>
    --%>
</section>
<jsp:include page="../General/footer.jsp"/>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script type="text/javascript" src="../js/jquery-ui-1.10.0.custom.js"></script>
<script src="../js/jquery-ui-1.10.0.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>


</body>
</html>