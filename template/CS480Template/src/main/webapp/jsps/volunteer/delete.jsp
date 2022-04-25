<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Volunteer</title>
    
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
  <h1>Delete Volunteer</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/VolunteerServlet/Delete'/>" method="post">
	Delete Volunteer ID   :<input type="text" name="volunteer_id" value="${form.volunteer_id }"/>
	<span style="color: red; font-weight: 900">${errors.volunteer_id }</span>
	<br/>
	<input type="submit" value="Delete Volunteer"/>
</form>
<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
		<tr>
				<th>Volunteer ID</th>
				<th>Volunteer Name</th>
				<th>Preferred Location</th>
				<th>Location Radius</th>
				<th>Availability Date</th>
		</tr>
		<c:forEach items="${volunteer}" var="volunteer">
			<tr>
				<td>${volunteer.users_id}</td>
				<td>${volunteer.volunteer_name}</td>
				<td>${volunteer.preferred_location}</td>
				<td>${volunteer.location_radius}</td>
				<td>${volunteer.availability_date}</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
