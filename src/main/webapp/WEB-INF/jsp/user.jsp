<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Project Team F</title>
</head>
<body>

<h2>User registration</h2>

<form:form method="post" action="add.html" commandName="contact">

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
            <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
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

<%--@elvariable id="userList" type="be.kdg.teamf.controller.UserController.getUserList()"--%>
<c:if  test="${!empty userList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.lastName}, ${user.firstName} </td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>