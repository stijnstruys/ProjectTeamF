<%--
  Created by IntelliJ IDEA.
  User: Jeroen
  Date: 7/02/13
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>User</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link href="../css/dot-luv/jquery-ui-1.10.0.custom.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../General/header.jsp"/>

    <section id="content">
        <a href="#" class="btn btn-success btn_green_right" id="user_modify_profile" class="btn_green_left">Modify</a>
        <h2>Profile</h2>

        <form:form class="form-horizontal" commandName="user">
            <div class="control-group">
                <label class="control-label" for="inputEmail">Username</label>
                <div class="controls">
                   <form:label class="checkbox" id="inputEmail" path="username" />
                   <form:input type="text" id="inputPassword" placeholder="Password" path="username"/>
                </div>
            </div>


        </form:form>


        <table>
            <tr>
                <td>Username</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>Name </td>
                <td>${user.firstName} ${user.lastName}</td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Telephone</td>
                <td>${user.telephone}</td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>${user.dateOfBirth}</td>
            </tr>
            <tr>
                <td>City</td>
                <td>${user.zipcode} ${user.city}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${user.street} ${user.number}</td>
            </tr>
        </table>
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