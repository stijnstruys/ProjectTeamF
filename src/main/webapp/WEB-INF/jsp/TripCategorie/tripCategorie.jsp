<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
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
    <title><spring:message code="label.tripCategory"/></title>
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
    <h2><spring:message code="label.addTripCategory"/></h2>
    <form:form method="post" action="add/${trip.tripId}.html" commandName="tripCategorie" id="tripCategorie">

        <table>
            <tr>
                <td><form:label path="tripCategorieName"><spring:message code="label.tripCategoryName"/></form:label></td>
                <td><form:input path="tripCategorieName"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="<spring:message code="label.addTripCategory"/>"/>
                </td>
            </tr>
        </table>
    </form:form>
</section>
<jsp:include page="../General/footer.jsp"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
    <script src="../js/jquery-ui-1.9.2.custom.js"></script>
    <script src="../js/vendor/bootstrap.min.js"></script>
    <script src="../js/plugins.js"></script>
    <script src="../js/main.js"></script>

</body>
</html>