<%--
  Created by IntelliJ IDEA.
  User: BART.LEEMANS
  Date: 6/02/13
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Contact Manager</h2>

<form:form method="post" action="add.html" commandName="user">

	<table>
	<tr>
		<td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
		<td><form:input path="firstname" /></td>
	</tr>

</table>
</form:form>


<h3>Users</h3>
<c:if  test="${!empty userList}">
<table class="data">
<tr>
	<th>Name</th>
</tr>
<c:forEach items="${userList}" var="user">
	<tr>
		<td>${user.firstName}</td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
