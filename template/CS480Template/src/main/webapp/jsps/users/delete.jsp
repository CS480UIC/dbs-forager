<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete User</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete User</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/UsersServlet/Delete'/>" method="post">
	
	Delete User ID   :<input type="text" name="user_id" value="${form.user_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	<input type="submit" value="Delete User"/>
</form>
<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
		<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Name of Organization</th>
				<th>Organization ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email ID</th>
				<th>Contact Number</th>
				<th>Address</th>
				
		</tr>
		<c:forEach items="${users}" var="users">
			<tr>
				<td>${users.ID}</td>
				<td>${users.username}</td>
				<td>${users.password}</td>
				<td>${users.name_of_organization}</td>
				<td>${users.org_id}</td>
				<td>${users.first_name}</td>
				<td>${users.last_name}</td>
				<td>${users.email_id}</td>
				<td>${users.contact_number}</td>
				<td>${users.address}</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
