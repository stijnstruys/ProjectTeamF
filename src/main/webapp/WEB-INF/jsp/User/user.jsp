<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
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

</head>
<body>
<section id="container">
    <jsp:include page="../General/header.jsp"/>

    <section id="content">
<h2>User registration</h2>

<form:form method="post" action="add.html" commandName="user" id="user">

    <table>
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
                <input type="submit" value="<spring:message code="label.addUser"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<h3>Users</h3>


<c:if  test="${!empty userList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.telephone"/></th>
            <th><spring:message code="label.dateOfBirth"/></th>
            <th><spring:message code="label.street"/></th>
            <th><spring:message code="label.city"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${userList}" var="user">


                <tr>
                    <td>${user.firstName}, ${user.lastName} </td>
                    <td>${user.email}</td>
                    <td>${user.telephone}</td>
                    <td>${user.dateOfBirth}</td>
                    <td>${user.street}  ${user.number}</td>
                    <td>${user.zipcode}, ${user.city}</td>
                    <td>
                        <a href="delete/${user.userID}.html">Delete</a>
                    </td>

                </tr>

        </c:forEach>
    </table>
</c:if>
        </section>
</section>
<footer>
    <div id="footer_info">
        &copy; 2013 - Team F - All rights reserved  <span id="footer_extrapadding">||</span>   <a href="#">info@teamf.com</a>  </br>
        Bart Leemans - Jeroen Dierckx - Jorne Raeymaekers - Stijn Struys - Jeroen Verheyen -  Jeroen Verbunt
    </div>


</footer>

                </c:forEach>
            </table>
        </c:if>
    <jsp:include page="General/footer.jsp"/>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.0.min.js"><\/script>')</script>
    <script src="../js/vendor/bootstrap.min.js"></script>
    <script src="../js/plugins.js"></script>
    <script src="../js/main.js"></script>
</body>
</html>