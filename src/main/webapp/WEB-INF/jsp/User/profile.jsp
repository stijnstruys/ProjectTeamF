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
        <a href="/ProjectTeamF-1.0/user/changepw.html" class="btn btn-success btn_green_right" id="user_change_password" class="btn_green_left">Change password</a>
        <a href="#" class="btn btn-success btn_green_right" id="user_modify_profile" class="btn_green_left">Modify</a>

        <h2>Profile</h2>
        <h4>General</h4>
        <form:form class="form-horizontal" commandName="user" action="/ProjectTeamF-1.0/user/update.html" method="POST">
            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Username</label></div>
                <div class="span3">
                    <label class="checkbox" >${user.username} </label>

                </div>

            </div>

            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Firstname</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.firstName} </label>
                    <form:input type="text" class="profile_input hidethis" path="firstName"/>
                </div>
                <div class="span2"><label class="profile_right">Lastname</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.lastName} </label>
                    <form:input type="text" class="profile_input hidethis" path="lastName"/>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Show position</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.showPosition} </label>
                    <form:input type="text" class="profile_input hidethis" path="showPosition"/>
                </div>

            </div>

            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Date of birth</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl">${user.dateOfBirth} </label>
                    <form:input class="datepicker profile_input hidethis" readonly="true" style="cursor: text;" path="dateOfBirth" />
                </div>
            </div>
            <h4>Contact</h4>
            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Email</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.email} </label>
                    <form:input type="text" class="profile_input hidethis" path="email"/>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Telephone</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.telephone} </label>
                    <form:input type="text" class="profile_input hidethis" path="telephone"/>
                </div>
            </div>

            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">City</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.city} </label>
                    <form:input type="text" class="profile_input hidethis" path="city"/>
                </div>
                <div class="span2"><label class="profile_right">Zipcode</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.zipcode} </label>
                    <form:input type="text" class="profile_input hidethis" path="zipcode"/>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span2" ><label class="profile_right">Street</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.street} </label>
                    <form:input type="text" class="profile_input hidethis" path="street"/>
                </div>
                <div class="span2"><label class="profile_right">Number</label></div>
                <div class="span3">
                    <label class="checkbox profile_lbl" >${user.number} </label>
                    <form:input type="text" class="profile_input hidethis" path="number"/>
                </div>
            </div>

            <div class="control-group profile_btns">
                <div class="controls">
                    <button type="submit" class="btn btn-primary hidethis profile_btns">Update changes</button>
                    <button type="button" class="btn hidethis profile_btns" id="profile_cancel">Cancel</button>
                </div>
            </div>
            <form:input type="text"  class="hidden fieldsnothere" path="userID" />
            <form:input type="text"  class="hidden fieldsnothere" path="username" />
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