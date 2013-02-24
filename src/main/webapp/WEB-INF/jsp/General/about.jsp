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
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.About"/></title>
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

<jsp:include page="header.jsp"/>

<section id="content">
    <section class="tripPages">
        <h2><spring:message code="label.About"/></h2>
        Als derdejaars studenten op de Karel de Grote hogeschool hebben wij voor het vak Software development de
        opdracht gekregen om zowel een webclient als een mobileclient op te bouwen. Voor deze opdracht waren er enkele
        aspecten zeer belangrijk. We moesten test-driven te werk gaan, iets wat voor ons volledig nieuw was. Daarnaast
        was het ook zeer belangrijk om in teamverband te werken, hierbij en bij het test-driven werken was het ook
        belangrijk dat we deden aan pair programming.</br></br>Hier vindt u wat meer informatie over ons:

        <table id="aboutTable">
            <tr>
                <td class="aboutColumn">
                    <img src="../img/groupMembers/profilePic.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Jeroen Dierckx</p>

                    <p>20, Herentals</p>

                    <p>Software Management</p>
                </td>
                <td class="aboutColumn">
                    <img src="http://www.fugly.com/media/IMAGES/WTF/fat-guy-in-a-diaper.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Bart Leemans</p>

                    <p>21, Meerle</p>

                    <p>Software Management</p>
                </td>
                <td class="aboutColumn">
                    <img src="../img/groupMembers/profilePic.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Jorne Raeymaeckers</p>

                    <p>20, Ranst</p>

                    <p>Applicatieontwikkeling - Bedrijfsapplicaties</p>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="../img/groupMembers/profilePic.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Stijn Struys</p>

                    <p>20, Wechelderzande</p>

                    <p>Applicatieontwikkeling - Bedrijfsapplicaties</p>
                </td>
                <td>
                    <img src="../img/groupMembers/JeroenVerbunt.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Jeroen Verbunt</p>

                    <p>24, Hoogstraten</p>

                    <p>Applicatieontwikkeling - Multimedia</p>
                </td>
                <td>
                    <img src="../img/groupMembers/profilePic.jpg" alt="Smiley face"
                         class="profilePictures"/>

                    <p>Jeroen Verheyen</p>

                    <p>20, Merksplas</p>

                    <p>Applicatieontwikkeling - Multimedia</p>
                </td>
            </tr>
        </table>
    </section>
</section>

<jsp:include page="footer.jsp"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
</body>
</html>
