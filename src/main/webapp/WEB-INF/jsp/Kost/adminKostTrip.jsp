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
    <title><spring:message code="label.costAdminTitle"/></title>
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
    <h2><spring:message code="label.costTripTitle"/> ${trip.tripName}</h2>
    <c:if test="${!empty deelnames}">

        <table>
            <th>Naam</th>
            <th>Totale Kost</th>
            <c:forEach items="${deelnames}" var="deelname">

                <c:if test="${!empty deelname.kosten }">
                    <tr>
                        <td>
                                ${deelname.user.firstName} ${deelname.user.lastName}
                        </td>
                        <c:set var="totaal" value="0"></c:set>
                        <c:forEach items="${deelname.kosten}" var="kost">
                            <c:set var="totaal" value="${totaal + kost.prijs}"></c:set>
                        </c:forEach>
                        <td>
                               € ${totaal}
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <br />
    </c:if>

</section>
<jsp:include page="../General/footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/social/FBLogin.js"></script>


</body>
</html>