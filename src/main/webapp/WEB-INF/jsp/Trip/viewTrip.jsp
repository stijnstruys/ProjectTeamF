<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
  Date: 7/02/13
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Trip</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
    <![endif]-->
        <jsp:include page="../../../../../../../../ProjectTeamF/src/main/webapp/WEB-INF/jsp/General/header.jsp"/>

        <section id="content">
            <h2>Trip</h2>
            <form:form method="post" action="tripOverzicht.html" commandName="trip" id="trip">
                <table>
                <tr>
                    <td><form:label path="tripName"><spring:message code="label.tripName"/></form:label></td>
                    <td><form:input path="tripName" /></td>
                </tr>
                <tr>
                    <td><form:label path="startDate"><spring:message code="label.startDate"/></form:label></td>
                    <td><form:input path="startDate" /></td>
                </tr>
                <tr>
                    <td><form:label path="endDate"><spring:message code="label.endDate"/></form:label></td>
                    <td><form:input path="endDate" /></td>
                </tr>
                <tr>
                    <td><form:label path="organiser"><spring:message code="label.organiser"/></form:label></td>
                    <td><form:input path="organiser" /></td>
                </tr>
                <tr>
                   <td><form:label path="startLocation"><spring:message code="label.startLocation"/></form:label></td>
                   <td><form:input path="startLocation" /></td>
               </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="<spring:message code="label.updateTrip"/>"/>
                    </td>
                    <td>
                        <a href="update/${trip.tripId}.html">Update</a>
                    </td>
                    <td>
                        <a href="delete/${trip.tripId}.html">Delete</a>
                    </td>
               </tr>

            </table>
            </form:form>
        </section>
            <jsp:include page="../../../../../../../../ProjectTeamF/src/main/webapp/WEB-INF/jsp/General/footer.jsp"/>


            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
            <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.0.min.js"><\/script>')</script>
            <script src="../js/vendor/bootstrap.min.js"></script>
            <script src="../js/plugins.js"></script>
            <script src="../js/main.js"></script>
</body>
</html>