<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
  Date: 11/02/13
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="label.BroadcastMessages"/></title>
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

        <form action="/ProjectTeamF-1.0/user/admincp-${trip.tripId}.html">
            <input type="submit" value="<spring:message code="label.Back"/>" class="btn btn-success btn_green_right">
        </form>
        <h2><spring:message code="label.sendBroadcastMessage"/></h2>


        <c:if test="${!empty trip.broadcastMessages}">
            <table class="broadcastMsgTable">
                <tr>
                    <th class="broadcastMsgTitle broadcastMsgCol1"><spring:message code="label.datetime"/></th>
                    <th class="broadcastMsgTitle broadcastMsgCol2"><spring:message code="label.message"/></th>

                </tr>
            </table>
            <div id="broadcastMsgScroll">
                <table class="broadcastMsgTable">
                    <% int count = 0; %>
                    <c:forEach items="${trip.broadcastMessages}" var="broadcastMes">
                        <tr id="broadcastMsgRow"><td></td></tr>
                        <tr id="broadcastMsgRow<%=count%>">
                            <td class="msg broadcastMsgCol1"> <fmt:formatDate value="${broadcastMes.date}" pattern="dd/MM/yyyy - HH:mm:ss"/></td>
                            <td class="msg broadcastMsgCol2">${broadcastMes.msg} </td>
                        </tr>
                        <% if(count == 0) {count = 1;} else {count = 0;}%>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <form:form method="post" action="add/${trip.tripId}.html" commandName="broadcastMessage" id="broadcastMessage"
                   class="form-horizontal2">
            <table class="broadcastMsgTable">
                <tr>
                    <td class="msg broadcastMsgCol1">
                        <input type="submit" id="addBroadcastMessage" class="btn" value="<spring:message code="label.sendMessage"/>"/>
                    </td>
                    <td class="msg broadcastMsgCol2">
                        <form:textarea type="text" path="msg" id="broadcastMsg"/>
                    </td>
                </tr>
            </table>
        </form:form>
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