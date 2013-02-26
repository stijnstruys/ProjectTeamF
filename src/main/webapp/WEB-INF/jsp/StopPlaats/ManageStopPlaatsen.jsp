<%--
  Created by IntelliJ IDEA.
  User: Jeroen
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
    <h2><spring:message code="label.ManageStoppingPoints"/></h2>
    <form:form method="post" action="add/${trip.tripId}.html" commandName="stopPlaats" id="stopPlaats">
        <table id="mapTopTable">
            <tr>
                <td class="mapTopTableCol1"><form:label path="adres"><spring:message code="label.address"/></form:label></td>
                <td class="mapTopTableCol1"><form:input id="address" path="adres"/></td>
                <td class="mapTopTableCol1">
                    <input id="searchKnop" type="submit" value="<spring:message code="label.AddStoppingPoint"/>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Mode of Travel: </strong></td>
                <td><select id="mode">
                    <option value="DRIVING">Driving</option>
                    <option value="WALKING">Walking</option>
                    <option value="BICYCLING">Bicycling</option>
                    <option value="TRANSIT">Transit</option>
                </select>
                </td>
            </tr>
        </table>
    </form:form>
    <section id="links">
        <%--  <input id="address" type="textbox" value="Groenplaats, Antwerpen">
          <input class="addressButton" type="button" value="Add stopping point">     --%>


        <table>
            <tr id="mapsRow0">
                <td>Location name</td>
            </tr>
            <c:if test="${!empty trip.stopPlaatsen}">
                    <c:forEach items="${trip.stopPlaatsen}" var="stopPlaatsen">
                            <tr>
                                <td><input id="adres" class="addresses" value="${stopPlaatsen.adres}"/></td>
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
                    </c:forEach>
            </c:if>


        </table>

    </section>
    <section id="rechts">
        <div id="map_canvas"></div>
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
<script src="../js/maps.js"></script>

</body>
</html>