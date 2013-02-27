<%--
  Created by IntelliJ IDEA.
  User: Jeroen
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
    <title><spring:message code="label.addTrip"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
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

<section id="content">
    <h2>Trip</h2>
    <div id="validation_failed"></div>
    <form:form method="post" action="add.html" commandName="trip" id="add_trip_form" class="form-horizontal">
        <div class="control-group">
            <form:label class="control-label" path="tripType"><spring:message code="label.tripType"/></form:label>
            <div class="controls">

                <form:select path="tripType">
                    <form:options items="${tripTypeList}" itemValue="tripTypeName" itemLabel="tripTypeName"/>
                </form:select>


            </div>
        </div>

        <div class="control-group" id="cg_tripname">
            <form:label class="control-label" path="tripName"><spring:message code="label.tripName"/></form:label>
            <div class="controls">
                <form:input type="text" id="tripname" path="tripName"/>
            </div>
        </div>

        <div class="control-group">
            <form:label class="control-label" path="tripDescription"><spring:message code="label.tripDescription"/></form:label>
            <div class="controls">
                <form:input type="text" id="tripDescription" path="tripDescription"/>
            </div>
        </div>

        <div class="control-group" id="cg_startdate">
            <form:label class="control-label" path="startDate"><spring:message code="label.startDate"/></form:label>
            <div class="controls">
                <form:input id="TripStartD" class="datepicker" readonly="true" style="cursor: text;" path="startDate"></form:input>
            </div>
        </div>

        <div class="control-group" id="cg_enddate">
            <form:label class="control-label" path="endDate"><spring:message code="label.endDate"/></form:label>
            <div class="controls">
                <form:input id="TripEndD" class="datepicker" readonly="true" style="cursor: text;" path="endDate"></form:input>
            </div>
        </div>

        <div class="control-group">
            <form:label class="control-label" path="startLocation"><spring:message code="label.startLocation"/></form:label>
            <div class="controls">
                <form:input type="text" id="startLocation" path="startLocation"/>
            </div>
        </div>

        <div class="control-group">
            <form:label class="control-label" path="notification"><spring:message code="label.notification"/></form:label>
            <div class="controls">
                <form:input type="text" id="notification" path="notification"/>
            </div>
        </div>

        <div class="control-group">
            <form:label class="control-label" path="equipment"><spring:message code="label.equipment"/></form:label>
            <div class="controls">
                <input type="text" id="equipment-input"/>
                <span class="help-inline"><a href="#" id="add_equipment">Add</a></span>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <form:select multiple="multiple" path="equipment" id="trip_equipment">
                </form:select>
                <span class="help-inline"><a href="#" id="remove_equipment">Remove selected</a></span>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button type="submit" id="trip_add" class="btn"><spring:message code="label.addTrip"/></button>
                <input name="reset" type="reset" class="btn" value="Reset" id="trip_reset"/>
            </div>
        </div>
    </form:form>

</section>
<jsp:include page="../General/footer.jsp"/>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/validation.js"></script>
</body>
</html>