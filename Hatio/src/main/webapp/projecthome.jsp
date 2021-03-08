<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class ="table" border="1">
	<tr>
		<th>project id</th>
		<th>project name</th>
		<th></th>
	</tr>
<c:forEach items="${plist}" var="project">
    <tr>      
        <td>${project.id}</td>
        <td>${project.projectName}</td>
        <td><button> <a href="taskhome${project.id}">show task</a></button></td>
    </tr>
</c:forEach>
</table>
<button><a href="projectadd">add</a></button>
</body>
</html>