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
<html class="no-js" xmlns:fb="http://ogp.me/ns/fb#"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.Home"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="../img/favicon.ico">
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
        <h2><spring:message code="label.Home"/></h2>
        <section class="homeSection">
            <section class="homeSectionLeft">
                <section class="homeSectionText"><p></br>
                    <spring:message code="label.HomeLine1"/>
                    </br>
                    <spring:message code="label.HomeLine2"/>
                    </br></br>
                    <spring:message code="label.HomeLine3"/>
                </p></section>
            </section>
            <section class="homeSectionRight">
                <img src="../img/homepagePictures/citytrip1.jpg" alt="Smiley face"
                     id="homePictures1"/>
            </section>
        </section>


        <section class="homeSection">
            <section class="homeSectionLeft">
                <img src="../img/homepagePictures/citytrip4.jpg" alt="Smiley face"
                     id="homePictures2"/></section>
            <section class="homeSectionRight">
                <section class="homeSectionText">
                    <p></br><spring:message code="label.HomeLine4"/></p>
                </section>
            </section>


            <section class="homeSection">
                <p></br><spring:message code="label.HomeLine5"/></p>
            </section>

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
