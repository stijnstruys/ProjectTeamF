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
    <title><spring:message code="label.ChangePassword"/></title>
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
    <h2><spring:message code="label.ChangePassword"/></h2>  </br>
    <form id="changepw_form" action="/ProjectTeamF-1.0/user/changepw.html" method="POST">
        <input type="password" id="currentpw" placeholder="<spring:message code="label.CurrentPassword"/>"
               name="currentpw"/>  </br>
        <input type="password" id="newpw" placeholder="<spring:message code="label.NewPassword"/>"
               name="newpw"/>   </br>
        <input type="password" id="confirmpw" placeholder="<spring:message code="label.ConfirmNewPassword"/>"
               name="confirmpw"/>   </br>  </br>
        <button type="submit" class="btn" id="changepw"><spring:message code="label.ChangePassword"/></button>
    </form>

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