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
    <h2><spring:message code="label.addTrip"/></h2>

    <form:form method="post" action="add.html" commandName="trip" id="add_trip_form" class="form-horizontal">

        <div id="add_trip_1" class="add_trip_div">
            <div class="control-group">
                <form:label class="control-label" path="tripType"><spring:message code="label.tripType"/></form:label>
                <div class="controls">
                    <select name="tripTypeSelect" id="tripTypeSelect">
                        <c:forEach var="item" items="${tripTypeList}">
                            <OPTION value="${item.tripTypeId}">${item.tripTypeName}</OPTION>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        </div>
        <div id="add_trip_2" class="add_trip_div">

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
            <div class="control-group">
                <div class="controls">
                    <label class="checkbox">
                        <form:checkbox path="visible" /><spring:message code="label.tripVisible"/>
                    </label>

                </div>
            </div>
        </div>
        <div id="add_trip_3" class="add_trip_div">
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
        </div>
        <div id="add_trip_4" class="add_trip_div">
            <div class="control-group" >
                <label class="control-label"><spring:message code="label.Interval"/></label>
                <div class="controls">
                    <select name="repetition">
                        <option value="1d"><spring:message code="label.Dagelijks"/></option>
                        <option value="1w"><spring:message code="label.Wekelijks"/>/option>
                        <option value="2w"><spring:message code="label.OmDe2Weken"/></option>
                        <option value="4m"><spring:message code="label.OmDe4Weken"/></option>
                    </select>
                </div>
            </div>
            <div class="control-group" id="cg_repetition">
                <form:label class="control-label" path="startDate"><spring:message code="label.totEnMet"/></form:label>
                <div class="controls">
                    <input type="text" id="temdate" class="datepicker" readonly="true" style="cursor: text;" name="dateUntill" />
                </div>
            </div>
        </div>
        <div id="add_trip_5" class="add_trip_div">
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
        </div>

        <div id="add_trip_6" class="add_trip_div">
            <div class="control-group">
                <form:label class="control-label" path="equipment"><spring:message code="label.equipment"/></form:label>
                <div class="controls">
                    <input type="text" id="equipment-input"/>
                    <span class="help-inline url"id="add_equipment"><spring:message code="label.Add"/></span>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <form:select multiple="multiple" path="equipment" id="trip_equipment">
                    </form:select>
                    <span class="help-inline url" id="remove_equipment"><spring:message code="label.removeSelected"/></span>
                </div>
            </div>
        </div>

        <div id="add_trip_7" class="add_trip_div">
            <div class="control-group">
                <div class="controls">
                    <button type="submit" id="trip_add" class="btn"><spring:message code="label.addTrip"/></button>
                    <input name="reset" type="reset" class="btn" value="Reset" id="trip_reset"/>
                </div>
            </div>
        </div>

        <ul class="pager" id="add_trip_btns">
            <li class="previous">
                <a href="#" id="add_trip_prev">&larr; <spring:message code="label.previous"/></a>
            </li>
            <li class="next">
                <a href="#" id="add_trip_next"><spring:message code="label.next"/> &rarr;</a>
            </li>
        </ul>
    </form:form>
    <div id="validation_failed"></div>
        <%--<div class="control-group">
            <form:label class="control-label" path="tripType"><spring:message code="label.tripType"/></form:label>
            <div class="controls">
                <select name="tripTypeSelect" id="tripTypeSelect">
                    <c:forEach var="item" items="${tripTypeList}">
                        <OPTION value="${item.tripTypeId}">${item.tripTypeName}</OPTION>
                    </c:forEach>
                </select>
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
                <span class="help-inline url"id="add_equipment">Add</span>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <form:select multiple="multiple" path="equipment" id="trip_equipment">
                </form:select>
                <span class="help-inline url" id="remove_equipment">Remove selected</span>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button type="submit" id="trip_add" class="btn"><spring:message code="label.addTrip"/></button>
                <input name="reset" type="reset" class="btn" value="Reset" id="trip_reset"/>
            </div>
        </div>
    </form:form>--%>

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