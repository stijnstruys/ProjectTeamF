<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>User</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../../css/main.css">
    <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body>
<section id="container">
    <jsp:include page="../General/header.jsp"/>

    <section id="content">
        <h2>Update User</h2>

        <form:form method="post" action="updateUser.html" commandName="user" id="user">

        <table>
            <tr>

                <td><form:hidden path="userID" /></td>
            </tr>
            <tr>
                <td><form:label path="username"><spring:message code="label.username"/></form:label></td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td><form:label path="firstName"><spring:message code="label.firstname"/></form:label></td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td><form:label path="lastName"><spring:message code="label.lastname"/></form:label></td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td><form:label path="dateOfBirth"><spring:message code="label.dateOfBirth"/></form:label></td>
                <td><form:input path="dateOfBirth" /></td>
            </tr>
            <tr>
                <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
                <td><form:input path="street" /></td>
            </tr>
            <tr>
                <td><form:label path="number"><spring:message code="label.number"/></form:label></td>
                <td><form:input path="number" /></td>
            </tr>
            <tr>
                <td><form:label path="zipcode"><spring:message code="label.zipcode"/></form:label></td>
                <td><form:input path="zipcode" /></td>
            </tr>
            <tr>
                <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.updateUser"/>"/>
                </td>
            </tr>
        </table>
        </form:form>

</body>
</html>