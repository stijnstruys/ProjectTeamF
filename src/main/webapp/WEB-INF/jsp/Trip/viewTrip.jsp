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
    <title><spring:message code="label.ViewTrip"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.9.2.custom.css" rel="stylesheet">
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to
    improve your experience.</p>
<![endif]-->
<jsp:include page="../General/header.jsp"/>

<section id="content">
    <section>
    <style>
        #content {
            background: ${trip.bgcolor};
            color: ${trip.fontcolorContent};
        }

        h2 {
            color: ${trip.fontcolorTitle};
        }

        h3 {
            color: ${trip.fontcolorTitle};
            text-align: center;
        }

    </style>
    <section class="formView">


        <table class="formTable">
            <tr>
                <td colspan="3">
                    <p class="formTrip">${trip.tripName}</p>
                </td>
                <td><c:if test="${registered != true}">
                    <form action="join/${trip.tripId}.html">
                        <input class="formButton" type="submit" value="<spring:message code="label.join"/>">
                    </form>
                </c:if>
                    <c:if test="${registered == true}">
                        <form action="leave/${trip.tripId}.html">
                            <input class="formButton" type="submit" value="<spring:message code="label.leaveTrip"/>">
                        </form>
                    </c:if></td>
            </tr>
            <tr>
                <td colspan="4">
                    <p class="formLabels">${trip.tripDescription}</p>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <p class="formLabels">${trip.notification}</p>
                </td>
            </tr>
            <tr>
                <td class="formColumns">
                    <p class="formLabels1"><spring:message code="label.startLocation"/></p>
                </td>
                <td>
                    <p class="formLabels1"><spring:message
                            code="label.organiser"/></p>
                </td>
                <td>
                    <p class="formLabels1"><spring:message code="label.startDate"/></p>
                </td>
                <td>
                    <p class="formLabels1"><spring:message
                            code="label.endDate"/></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="formLabels2">${trip.startLocation}</p>
                </td>
                <td>
                    <p class="formLabels2">${trip.organiser.firstName} ${trip.organiser.lastName}</p>
                </td>
                <td>
                    <p class="formLabels2"><fmt:formatDate value="${trip.startDate}"
                                                           pattern="dd-MM-yyyy"/></p>
                </td>
                <td>
                    <p class="formLabels2"><fmt:formatDate value="${trip.endDate}"
                                                           pattern="dd-MM-yyyy"/></p>
                </td>
            </tr>
            <tr>
                <td><p class="formLabels1"><spring:message code="label.equipment"/></p></td>
            </tr>
                  <c:if test="${!empty trip.equipment}">
                <%
                    int counter = 1;
                    int counter2 = 4;
                %>
                <c:forEach items="${trip.equipment}" var="value">
                    <% if (counter == 1 || counter == (counter2 + 1)) {%>
                    <tr><% }%>
                        <td>${value}</td>
                        <% if (counter == counter2) {%>
                    </tr>
                    <% counter2 = counter2 + 4;
                    } %>
                    <% counter++; %>
                </c:forEach>
            </c:if>
           <tr>
                <td><p class="formLabels1"><spring:message code="label.Categories"/></p></td>
            </tr>
            <c:if test="${!empty trip.tripCategorieen}">
                <%
                    int counter = 1;
                    int counter2 = 4;
                %>
                <c:forEach items="${trip.tripCategorieen}" var="value">
                    <% if (counter == 1 || counter == (counter2 + 1)) {%>
                    <tr><% }%>
                        <td>${value.tripCategorieName}</td>
                        <% if (counter == counter2) {%>
                    </tr>
                    <% counter2 = counter2 + 4;
                    } %>
                    <% counter++; %>
                </c:forEach>
            </c:if>
            <tr>
                <td><p class="formLabels1"><spring:message code="label.StoppingPoints"/></p></td>
            </tr>
            <c:if test="${!empty trip.stopPlaatsen}">
                <%
                    int counter = 1;
                    int counter2 = 4;
                %>
                <c:forEach items="${trip.stopPlaatsen}" var="value">
                    <% if (counter == 1 || counter == (counter2 + 1)) {%>
                    <tr><% }%>
                        <td>${value.adres}</td>
                        <% if (counter == counter2) {%>
                    </tr>
                    <% counter2 = counter2 + 4;
                    } %>
                    <% counter++; %>
                </c:forEach>
            </c:if>
            <tr>
             <tr>
                <td><p class="formTrip"><spring:message code="label.Participants"/></p></td>
            </tr>
            <c:if test="${!empty trip.deelnames}">

                <tr>
                    <td><p class="formLabels1"><spring:message code="label.name"/></p></td>
                    <td><p class="formLabels1"><spring:message code="label.IndividualEquipment"/></p></td>
                </tr>
                <c:forEach items="${trip.deelnames}" var="deelname">
                    <tr>
                       <td><a class="formLabels2">${deelname.user.firstName} ${deelname.user.lastName} </a></td>
                        <td>
                        <c:forEach items="${deelname.equipment}" var="equip">
                        <span class="formLabels2">${equip} </span>
                </c:forEach>          </td>
                    </tr>
                </c:forEach>

            </c:if>
        </table>
    </section>
    </section>

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