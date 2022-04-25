<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Volunteer</title>
    
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
  <h1>Update Volunteer</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/VolunteerServlet/Update'/>" method="post">
	Volunteer/User ID    :<input type="text" name="users_id" value="${form.users_id }"/>
	<span style="color: red; font-weight: 900">${errors.users_id }</span>
	<br/>
	Update Volunteer Name    :<input type="text" name="volunteer_name" value="${form.volunteer_name }"/>
	<span style="color: red; font-weight: 900">${errors.volunteer_name }</span>
	<br/>
	Update Preferred Location   ：<input type="text" name="preferred_location" value="${form.preferred_location }"/>
	<span style="color: red; font-weight: 900">${errors.preferred_location }</span>
	<br/>
	Update Location Radius	：<input type="text" name="location_radius" value="${form.location_radius }"/>
	<span style="color: red; font-weight: 900">${errors.location_radius }</span>
	<br/>
	Update Availability Dates	：<input type="text" name="availability_dates" value="${form.availability_dates }"/>
	<span style="color: red; font-weight: 900">${errors.availability_dates }</span>
	<br/>
	<input type="submit" value="Update Volunteer"/>
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
