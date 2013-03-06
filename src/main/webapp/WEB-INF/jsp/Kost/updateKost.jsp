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
    <title><spring:message code="label.updateCost"/></title>
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
        <h2><spring:message code="label.updateCost"/></h2>

        <div id="validation_failed"></div>
        <form:form method="post" action="update/${kost.kostId}.html" commandName="kost"
                   id="kost" onsubmit="false">
            <table>
                <tr>
                    <td><form:hidden path="kostId"/></td>
                </tr>
                <tr>
                    <td><form:label path="beschrijving"><spring:message
                            code="label.costDescription"/></form:label></td>
                    <td><form:input id="kostBeschrijving" path="beschrijving"/></td>
                </tr>
                <tr>
                    <td><form:label path="prijs"><spring:message
                            code="label.costPrice"/></form:label></td>
                    <td><form:input id="kostPrijs" path="prijs"/></td>
                </tr>
                <td>
                    <input type="submit" id="updateKost" class="btn" value="<spring:message code="label.updateCost"/>"/>
                </td>
                </tr>
            </table>
        </form:form>
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