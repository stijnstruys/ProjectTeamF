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


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.UpdateStoppingPoint"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
    <script>
        var counter = 1;
        function addAntwoord() {

            $("#newAntwoord").before('<tr><td id=antwoordnew' + counter + ' ><input type="text" value="" name="antwoorden"/><button class="btn"  type="button" onclick="removeAntwoord(\'antwoordnew' + counter + '\')">X</button></td></tr>');
            counter++;
        }
        function removeAntwoord(s) {
            $("#" + s).remove();
        }
    </script>
</head>
<body>
<section id="container">
    <jsp:include page="../General/header.jsp"/>
        <%
        int count = 0;
     %>
    <section id="content">
        <section class="tripPages">
            <h2><spring:message code="label.UpdateStoppingPoint"/></h2>

            <div id="validation_failed2"><spring:message code="label.badMapEntry"/></div>
            <form:form method="post" action="updateStopplaats/${tripID}.html" commandName="stopPlaats"
                       id="updateStopPlaats">
                <div class="pull-right" id="map_canvas"></div>
                <form:hidden path="stopPlaatsID"/>

                <form:label class="lbl" path="adres"><spring:message code="label.address"/></form:label>
                <form:input path="adres" id="address"/>
                    <span class="help-inline">
                        <img src="../img/icons/Google-Maps-icon.png" alt="google maps icon" class="mapIcons"
                             id="mapCheckIcon"/>
                    </span>

                <form:label class="lbl" path="naam"><spring:message code="label.StoppingPointName"/></form:label>
                <form:input path="naam" id="spNaam"/>

                <form:label class="lbl" path="type"><spring:message code="label.StoppingPointType"/></form:label>
                <form:input path="type" id="sptype"/>

                <form:label class="lbl" path="informatie"><spring:message code="label.information"/></form:label>
                <form:textarea id="stopPlaatsInfo" path="informatie"/>

                <div class="clearfix">
                    &nbsp;
                </div>

                <div class="row" id="stopplaatsen-extra">
                    <div class="span4">

                        <form:label class="lbl" path="vraag"><spring:message code="label.Vraag"/></form:label>
                        <form:input path="vraag" id="vraag"/>

                        <form:label class="lbl" path="correctAntwoord"><spring:message
                                code="label.CorrectAntwoord"/></form:label>
                        <form:input path="correctAntwoord" id="correctAntwoord"/>
                    </div>

                    <div class="span5">
                        <form:label class="lbl" path="antwoorden"><spring:message code="label.Antwoorden"/></form:label>

                        <input type="text" id="antw-input"/>
                        <span class="help-inline url" id="add_antw"><spring:message code="label.Add"/></span>

                        <form:select multiple="multiple" path="antwoorden" id="antwoorden">
                            <c:forEach items="${stopPlaats.antwoorden}" var="antw">
                                <form:option value="${antw}"> ${antw}</form:option>
                            </c:forEach>
                        </form:select>
                        <span class="help-inline url" id="remove_antw"><spring:message
                                code="label.removeSelected"/></span>
                    </div>
                </div>
                <label class="checkbox">
                    <form:checkbox path="vrijgegeven" id="spvrijgegeven"/> <form:label class="lbl"
                                                                                       path="vrijgegeven"><spring:message
                        code="label.Released"/></form:label>
                </label>


                <input type="button" class="btn" id="updateStopplaatsBtn"
                       value="<spring:message code="label.UpdateStoppingPoint"/>"/>
            </form:form>
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
    <script src="../js/mapScripts/mapsUpdate.js"></script>
</body>
</html>