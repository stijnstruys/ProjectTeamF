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

        <h2><spring:message code="label.UserRegistration"/></h2>

        <div id="validation_failed"></div>
        <form:form method="post" class="form-horizontal" action="add.html" commandName="user" id="user"
                   enctype="multipart/form-data">
            <legend><spring:message code="label.General"/></legend>
            <div class="control-group">
                <form:label id="labelUsername" class="control-label" path="username"><spring:message
                        code="label.username"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input type="text" id="userName" path="username"/>
                        <span class="add-on" id="addon_username"></span>
                    </div>
                </div>
            </div>

            <div class="control-group">
                <form:label id="labelPassword" class="control-label" path="password"><spring:message
                        code="label.password"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input type="password" id="password" path="password"/>
                        <span class="add-on" id="addon_password"></span>
                    </div>
                </div>
            </div>

            <legend><spring:message code="label.Personal"/></legend>
            <div class="control-group">
                <form:label class="control-label" path="firstName"><spring:message code="label.firstname"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input type="text" path="firstName" id="firstname"/>
                        <span class="add-on" id="addon_firstname"></span>
                    </div>

                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="lastName"><spring:message code="label.lastname"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input type="text" path="lastName" id="lastname"/>
                        <span class="add-on" id="addon_lastname"></span>
                    </div>

                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="dateOfBirth"><spring:message
                        code="label.dateOfBirth"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input id="dateOfBirth" class="datepicker" readonly="true" style="cursor: text;"
                                    path="dateOfBirth"/>
                        <span class="add-on" id="addon_dob"></span>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="profielFoto"><spring:message code="label.photo"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <input type="text" disabled id="browse_foto_input"/>
                        <a class="btn" id="browse_foto"><spring:message code="label.Browse"/></a>
                    </div>

                    <input type="file" name="foto" id="foto" style="display: none"/>
                </div>
            </div>
            <legend><spring:message code="label.contact"/></legend>
            <div class="control-group">
                <form:label id="labelEmail" class="control-label" path="email"><spring:message
                        code="label.email"/></form:label>
                <div class="controls">
                    <div class="input-append">
                        <form:input type="text" id="email" path="email"/>
                        <span class="add-on" id="addon_email"></span>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="telephone"><spring:message code="label.telephone"/></form:label>
                <div class="controls">
                    <form:input type="text" path="telephone"/>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="street"><spring:message code="label.street"/></form:label>
                <div class="controls">
                    <form:input type="text" path="street"/>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="number"><spring:message code="label.number"/></form:label>
                <div class="controls">
                    <form:input type="text" path="number"/>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="zipcode"><spring:message code="label.zipcode"/></form:label>
                <div class="controls">
                    <form:input type="text" path="zipcode"/>
                </div>
            </div>
            <div class="control-group">
                <form:label class="control-label" path="city"><spring:message code="label.city"/></form:label>
                <div class="controls">
                    <form:input type="text" path="city"/>
                </div>
            </div>

            </br>

            <div class="control-group">
                <div class="controls">
                    <input type="submit" id="register_submit" class="btn"
                           value="<spring:message code="label.Register"/>"/>
                    <a class="btn" type="button" id="user_importfb"><spring:message
                            code="label.ImportDateFromFacebook"/></a>
                </div>
            </div>


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
<script src="../js/validation.js"></script>
<script src="../js/social/FBImport.js"></script>
</body>
</html>