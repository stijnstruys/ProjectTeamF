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

    <h2><spring:message code="label.pers_equipment"/></h2>
    </br>
    <form:form id="viewTripForm" method="post" action="../TripParticipants/updateDeelname.html" commandName="deelname"
               class="form-horizontal">


        <form:hidden path="deelnameID"></form:hidden>
        <div class="control-group">
            <form:label class="control-label" path="equipment"><spring:message code="label.p_equipment"/></form:label>
            <div class="controls">
                <input type="text" id="equipment-input"/>
                <span class="help-inline url" id="add_equipment"><spring:message code="label.tripAdd"/></span>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <form:select multiple="multiple" path="equipment" id="trip_equipment">

                    <c:forEach items="${deelname.equipment}" var="equipmentPiece">
                        <form:option value="${equipmentPiece}"> ${equipmentPiece}</form:option>
                    </c:forEach>
                </form:select>
                <span class="help-inline url" id="remove_equipment"><spring:message code="label.removeSelected"/></span>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input class="btn" id="editequipmentbtn" type="submit"
                       value="<spring:message code="label.updateParticipant"/>">
            </div>
        </div>

    </form:form>

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