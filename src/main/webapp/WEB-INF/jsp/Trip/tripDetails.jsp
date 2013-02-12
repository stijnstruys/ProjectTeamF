<%--
  Created by IntelliJ IDEA.
  User: Jorne
  Date: 11/02/13
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <title>Trip Details</title>

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.10.0.custom.css" rel="stylesheet">
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->
<jsp:include page="../General/header.jsp"/>
<section id="content">
    <table>
        <tr>
            <td>Naam</td><td>${trip.tripName}</td>
        </tr>
        <tr>
            <td>Start Date</td><td>${trip.startDate}</td>
        </tr>
        <tr>
            <td>End Date</td><td>${trip.endDate}</td>
        </tr>
        <tr>
            <td>Organiser</td><td>${trip.organiser}</td>
        </tr>
        <tr>
            <td>Start locatie</td><td>${trip.startLocation}</td>
        </tr>

    </table>

    <c:if  test="${!empty trip.stopPlaatsen}">
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
    <form action ="/ProjectTeamF-1.0/StopPlaats/stopPlaats/${trip.tripId}.html">

        <input type="submit" value="Add new Stop Place"/>
    </form>

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