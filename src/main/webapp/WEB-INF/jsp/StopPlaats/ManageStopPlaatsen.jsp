<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
  Date: 26/02/13
  Time: 13:47
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
    <title><spring:message code="label.StoppingPoint"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
    <section class="tripPages">
        <h2><spring:message code="label.ManageStoppingPoints"/></h2>
        <table class="mapManageTable">
            <tr>
                <td>
                    <form:form method="post" action="add/${trip.tripId}.html" commandName="stopPlaats" id="addStopPlaats" onsubmit="false">
                        <table>
                            <tr>
                                <td><form:label class="lbl" path="adres"><spring:message
                                        code="label.address"/></form:label></td>
                            </tr>
                            <tr>
                                <td><form:input id="address" path="adres"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input id="searchKnop" class="btn" type="button"
                                           value="<spring:message code="label.AddStoppingPoint"/>"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
                <td class="mapManageTableRight">
                    <form:form method="post" action="updateTrip.html" commandName="trip"
                               id="stopPlaatsSettings" class="form-horizontal">
                        <div id="mapRelease" class="control-group">
                            <table>
                                <tr>
                                    <form:hidden path="tripId"/>
                                    <td><form:label class="lbl" path="travelType"><spring:message
                                            code="label.ModeOfTravel"/></form:label></td>
                                    <td><form:select path="travelType" id="mode">
                                        <form:option value="DRIVING">Driving</form:option>
                                        <form:option value="WALKING">Walking</form:option>
                                        <form:option value="BICYCLING">Bicycling</form:option>
                                        <form:option value="TRANSIT">Transit</form:option>
                                    </form:select></td>
                                </tr>
                                <tr>
                                    <td><form:label class="lbl" path="showMap"><spring:message
                                            code="label.showMap"/></form:label></td>
                                    <td><form:checkbox class="checkbox" path="showMap"/></td>
                                </tr>
                                <td>
                                    <input type="submit" class="btn"
                                           value="<spring:message code="label.SaveSettings"/>"/>
                                </td>
                                </tr>
                            </table>
                        </div>
                    </form:form>
                </td>
            </tr>
        </table>
        <section class="mapManageMiddle">
        <section id="links">
            <table>
                <tr id="mapsRow0">
                    <td><label><spring:message code="label.LocationName"/></label></td>
                </tr>
                <c:if test="${!empty trip.stopPlaatsen}">
                    <table class="data">
                        <c:forEach items="${trip.stopPlaatsen}" var="stopPlaatsen">
                            <table>
                                <tr>
                                    <td><input type="text" readonly="true" id="adres" class="addresses" value="${stopPlaatsen.adres}"/></td>
                                    <td>
                                        <a href="/ProjectTeamF-1.0/StopPlaats/${trip.tripId}.html">
                                            <img src="../img/icons/edit-validated-icon.png" alt="Smiley face"
                                                 class="mapIcons"/></a>
                                    </td>
                                    <td>
                                        <a href="/ProjectTeamF-1.0/StopPlaats/delete/${stopPlaatsen.stopPlaatsID}.html">
                                            <img src="../img/icons/Actions-edit-delete-icon.png" alt="Smiley face"
                                                 class="mapIcons"/></a>
                                    </td>
                                </tr>
                            </table>
                        </c:forEach>
                    </table>
                </c:if>
            </table>
        </section>
    </section>
    <section id="rechts">
        <div id="map_canvas"></div>
    </section>
    </section>
    <section id="onder"></section>
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
<script src="../js/mapScripts/maps.js"></script>

</body>
</html>