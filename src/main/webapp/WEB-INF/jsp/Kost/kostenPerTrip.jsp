<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
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
    <title><spring:message code="label.costTripTitle"/> ${trip.tripName}</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>

<body>
<jsp:include page="../General/header.jsp"/>

<section id="content">
    <section class="tripPages">
        <h2><spring:message code="label.costTripTitle"/> ${trip.tripName}</h2>

        <div id="validation_failed"></div>
        <form:form method="post" class="form-horizontal" action="add.html" commandName="kost" id="kost"
                   onsubmit="false">
            <input type="hidden" name="tripId" value="${trip.tripId}">

            <div class="control-group">
                <form:label class="control-label" path="beschrijving"><spring:message
                        code="label.costDescription"/></form:label>
                <div class="controls">
                    <form:input type="text" id="kostBeschrijving" path="beschrijving"/>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="prijs"><spring:message code="label.costPrice"/></form:label>
                <div class="controls">
                    <form:input type="text" id="kostPrijs" path="prijs"/>
                </div>
            </div>
            <input type="submit" id="addKost" value="<spring:message code="label.addKost"/>" class="btn controls">
        </form:form>
        <c:if test="${!empty deelname.kosten}">

            <c:set var="totaal" value="0"></c:set>
            <table class="costTable2">
                <th class="costs" id="costsCol1kpt"><spring:message code="label.costDescription"/></th>
                <th class="costs2" id="costsCol2kpt"><spring:message code="label.costPrice"/></th>
                <c:forEach items="${deelname.kosten}" var="kost">
                    <%--<c:if test="${deelnameUser.username == currentUser}">--%>

                    <tr>
                        <td class="costs">
                                ${kost.beschrijving}
                        </td>
                        <td class="costs2">
                            € ${kost.prijs}
                        </td>
                        <td>
                            <button class="btn btn-small"
                                    onClick="location.href='/ProjectTeamF-1.0/kost/update-${kost.kostId}.html'">
                                <spring:message
                                        code="label.update"/></button>
                        </td>
                        <td>
                            <button class="btn btn-inverse btn-small"
                                    onClick="location.href='/ProjectTeamF-1.0/kost/delete/${kost.kostId}.html'">
                                <spring:message code="label.Delete"/></button>
                        </td>
                    </tr>
                    <c:set var="totaal" value="${totaal + kost.prijs}"></c:set>
                    <%-- </c:if>--%>
                </c:forEach>
                <tr>
                    <td>&nbsp</td>
                </tr>
                <tr>
                    <td class="total"><spring:message code="label.totalCost"/>:</td>
                    <td class="total"> € ${totaal}</td>
                </tr>
            </table>
            <br/>
        </c:if>

    </section>
</section>
<jsp:include page="../General/footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/validation.js"></script>
<script src="../js/social/FBLogin.js"></script>


</body>
</html>