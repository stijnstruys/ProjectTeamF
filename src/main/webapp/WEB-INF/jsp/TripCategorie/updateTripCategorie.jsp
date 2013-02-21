<%--
  Created by IntelliJ IDEA.
  User: Jeroen Verbunt
  Date: 7/02/13
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><spring:message code="label.updateTripCategory"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../../css/main.css">
    <script src="../../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../../css/dot-luv/jquery-ui-1.10.0.custom.css" rel="stylesheet">
</head>
<body>
<section id="container">
    <jsp:include page="../General/header.jsp"/>

    <section id="content">
        <h2><spring:message code="label.updateTripCategory"/></h2>

        <form:form method="post" action="updateTripCategorie/${tripID}.html" commandName="tripCategorie" id="tripCategorie">


            <table>
                <tr>

                    <td><form:hidden path="tripCategorieId" /></td>
                </tr>
                <tr>
                    <td><form:label path="tripCategorieName"><spring:message code="label.tripCategoryName"/></form:label></td>
                    <td><form:input path="tripCategorieName" /></td>
                </tr>
                    <td>
                        <input type="submit" value="<spring:message code="label.updateTripCategory"/>"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </section>
    <jsp:include page="../General/footer.jsp"/>

      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
      <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
      <script type="text/javascript" src="../js/jquery-ui-1.10.0.custom.js"></script>
      <script src="../js/jquery-ui-1.10.0.custom.js"></script>
      <script src="../js/vendor/bootstrap.min.js"></script>
      <script src="../js/plugins.js"></script>
      <script src="../js/main.js"></script>
</body>
</html>