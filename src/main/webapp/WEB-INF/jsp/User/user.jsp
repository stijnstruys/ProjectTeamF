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
    <title><spring:message code="label.UserRegistration"/></title>
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
    <section class="tripPages">
    <h2><spring:message code="label.UserRegistration"/></h2>
    <div id="validation_failed"></div>
    <form:form method="post" action="add.html" commandName="user" id="user" enctype="multipart/form-data">

        <table>
            <tr>
                <td><form:label path="username"><spring:message code="label.username"/></form:label></td>
                <td>
                    <div class="input-append">
                        <form:input path="username" id="userName"/>
                        <span class="add-on" id="addon_username"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                <td>
                    <div class="input-append">
                        <form:password id="password" path="password"/>
                        <span class="add-on" id="addon_password"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
                <td>
                    <div class="input-append">
                        <form:input path="email" id="email"/>
                        <span class="add-on" id="addon_email"></span>
                    </div>
                </td>

            </tr>
            <tr>
                <td><form:label path="firstName"><spring:message code="label.firstname"/></form:label></td>
                <td><form:input path="firstName" id="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName"><spring:message code="label.lastname"/></form:label></td>
                <td><form:input path="lastName" id="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="dateOfBirth"><spring:message code="label.dateOfBirth"/></form:label></td>
                <td>
                    <div class="input-append">
                        <form:input class="datepicker" readonly="true" style="cursor: text;" path="dateOfBirth" id="dateOfBirth"/>
                        <span class="add-on" id="addon_dob"></span>
                    </div>
                </td>
            </tr>

            <tr>
                <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
                <td><form:input path="telephone" id="telephone"/></td>
            </tr>
            <tr>
                <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
                <td><form:input path="street"/></td>
            </tr>
            <tr>
                <td><form:label path="number"><spring:message code="label.number"/></form:label></td>
                <td><form:input path="number"/></td>
            </tr>
            <tr>
                <td><form:label path="zipcode"><spring:message code="label.zipcode"/></form:label></td>
                <td><form:input path="zipcode"/></td>
            </tr>
            <tr>
                <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
                <td><form:input path="city" id="city"/></td>
            </tr>
            <tr>
                <td><form:label path="profielFoto"><spring:message code="label.photo"/></form:label></td>
                <td><input type="file" name="foto" id="foto"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" id="register_submit" class="btn" value="<spring:message code="label.Register"/>"/>
                </td>
            </tr>
        </table>
    </form:form>

    <button class="btn" type="button" id="user_importfb">Import data from Facebook</button>

</section>  </section>
<jsp:include page="../General/footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/validation.js"></script>
<script src="../js/social/FBImport.js"></script>
</body>
</html>