<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath(); 
%>
<%=path %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	this is the list page

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userVO" items="${userVOs}">
				<tr>
					<td>${userVO.id}</td>
					<td>${userVO.name}</td>
					<td><a href="<%=path%>/test/view/${userVO.id}">View</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>