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
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.ManageParticipants"/></title>
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
        <h2><spring:message code="label.ManageParticipants"/></h2>
        </br>

        <c:if test="${!empty deelnemers}">
            <table class="data table">
                <tr>
                    <th>#</th>
                    <th><spring:message code="label.name"/></th>
                    <th><spring:message code="label.IndividualEquipment"/></th>
                </tr>
                <% int counter = 1;%>
                <c:forEach items="${trip.deelnames}" var="deelnamevar">
                    <tr>
                        <td><%=counter++%>
                        </td>
                        <td>
                            <a href="../editUserequipment/${deelnamevar.deelnameID}.html">${deelnamevar.user.firstName} ${deelnamevar.user.lastName} </a>
                        </td>
                        <c:if test="${!empty deelnamevar.equipment}">
                            <td>
                                <c:forEach items="${deelnamevar.equipment}" var="equipmentPiece">
                                    ${equipmentPiece}</br>
                                </c:forEach>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <form method="post" action="${trip.tripId}/invite.html" class="form-horizontal" id="form-participants">
            <legend><spring:message code="label.invitenewparticipants"></spring:message></legend>

            <div class="control-group">
                <label id="labelEmail" class="control-label"><spring:message
                        code="label.email"/></label>
                <div class="controls">
                    <div class="input-append">
                        <input type="text" id="participants-email" name="email"/>
                        <span class="add-on" id="addon_email"></span>
                    </div>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input class="btn" type="submit" value="<spring:message code="label.invite"/>">
                </div>
            </div>
        </form>
        <div id="validation_failed"></div>
    </section>
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