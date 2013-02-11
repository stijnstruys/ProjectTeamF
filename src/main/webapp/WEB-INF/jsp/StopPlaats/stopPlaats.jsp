<%--
  Created by IntelliJ IDEA.
  User: Jorne
  Date: 11/02/13
  Time: 8:14
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
    <title>StopPlaats</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
<jsp:include page="../General/header.jsp"/>

<section id="content">
    <h2>Stopplaats Toevoegen</h2>
    <form:form method="post" action="add/${trip.tripId}.html" commandName="stopPlaats" id="stopPlaats">

    <table>
        <tr>
            <td><form:label path="adres"><spring:message code="label.adres"/></form:label></td>
            <td><form:input path="adres"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message code="label.addStopPlaats"/>"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>