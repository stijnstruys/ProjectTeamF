<!--
Created by IntelliJ IDEA.
User: Jorne
Date: 5/02/13
Time: 13:31
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.Home"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
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

<jsp:include page="header.jsp"/>

<section id="content">
    <section class="tripPages">
        <h2><spring:message code="label.login"/></h2>

        <section class="homeSection">

            <p>
                <spring:message code="label.YouMustBeLoggedIn"/>
                U moet aangemeld zijn om op deze pagina te komen.

            <form name='f'
                  action="<c:url value='/ProjectTeamF-1.0/j_spring_security_check' />"
                  method='POST'>
                <div>
                    <spring:message code="label.username"/> <input type='text' name='j_username' class="input"
                                                                   placeholder="Username"> <br/>
                    <spring:message code="label.password"/> <input type='password' name='j_password' class="input"
                                                                   placeholder="Password"/>

                    <div>
                        <input name="submit" type="submit" value="Log in" class="btn"/>
                        <input name="reset" type="reset" class="btn" value="Reset"/>

                        <p class="divider"></p>
                        <fb:login-button autologoutlink='true' perms='email,user_birthday,status_update,publish_stream'
                                         id="fblogin"></fb:login-button>
                    </div>
                </div>
            </form>
            <spring:message code="label.NotRegistered"/> <a href="/ProjectTeamF-1.0/user/user.html"> <spring:message
                code="label.RegisterHere"/></a>
            </p>

        </section>
    </section>
</section>
<jsp:include page="footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
<script src="../js/social/FBLogin.js"></script>
<script src="http://connect.facebook.net/nl_NL/all.js#xfbml=1&appId=534896926530393" type="text/javascript"></script>

</body>
</html>
