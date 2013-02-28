<%--
  Created by IntelliJ IDEA.
  User: Jorne
  Date: 11/02/13
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.UpdateStoppingPoint"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">

</head>
<body>
<section id="container">
    <jsp:include page="../General/header.jsp"/>

    <section id="content">
        <section class="tripPages">
            <h2><spring:message code="label.UpdateStoppingPoint"/></h2>

            <div id="validation_failed2"><spring:message code="label.badMapEntry"/></div>
            <form:form method="post" action="updateStopplaats/${tripID}.html" commandName="stopPlaats"
                       id="updateStopPlaats">
                <table>
                    <tr>
                        <td><form:hidden path="stopPlaatsID"/></td>
                    </tr>
                    <tr>
                        <td><form:label class="lbl" path="adres"><spring:message
                                code="label.address"/></form:label></td>
                    </tr>
                    <tr>
                        <td><form:input path="adres" id="address"/></td>
                        <td><img src="../img/icons/Google-Maps-icon.png" alt="Smiley face" class="mapIcons"
                                 id="mapCheckIcon"/></td>
                        <td rowspan="8">
                            <div id="map_canvas3"></div>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label class="lbl" path="naam"><spring:message
                                code="label.StoppingPointName"/></form:label></td>
                    </tr>
                    <tr>
                        <td><form:input path="naam" id="spNaam"/></td>
                    </tr>
                    <tr>
                        <td><form:label class="lbl" path="type"><spring:message
                                code="label.StoppingPointType"/></form:label></td>
                    </tr>
                    <tr>
                        <td><form:input path="type" id="sptype"/></td>
                    </tr>
                    <tr>
                        <td><form:label class="lbl" path="informatie"><spring:message
                                code="label.information"/></form:label></td>
                    </tr>
                    <tr>
                        <td colspan="2"><form:textarea id="stopPlaatsInfo" path="informatie"/></td>
                    </tr>
                    <tr>
                        <td><form:label class="lbl" path="vrijgegeven"><spring:message
                                code="label.Released"/></form:label>
                            <label class="checkbox">
                                <form:checkbox path="vrijgegeven"/>
                            </label></td>
                    </tr>
                    <td colspan="2">
                        <input type="button" class="btn" id="updateStopplaatsBtn"
                               value="<spring:message code="label.UpdateStoppingPoint"/>"/>
                    </td>
                    </tr>
                </table>

            </form:form>
        </section>
    </section>
    <jsp:include page="../General/footer.jsp"/>

    <!--google maps api-->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
    <script src="../js/jquery-ui-1.9.2.custom.js"></script>
    <script src="../js/vendor/bootstrap.min.js"></script>
    <script src="../js/plugins.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/mapScripts/mapsUpdate.js"></script>
</body>
</html>