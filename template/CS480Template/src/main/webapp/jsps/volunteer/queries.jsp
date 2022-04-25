<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title> Volunteer Queries</title>
    
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
  <h1>Volunteer queries</h1>
<form action="<c:url value='/VolunteerServlet/Queries/Simple'/>" method="post">
	<input type="submit" value="Show volunteers available to travel more than 10 miles"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Volunteer ID</th>
			<th>Distance</th>
		</tr>
		<c:forEach items="${simpleQuery}" var="simpleDTO">
			<tr>
				<td>${simpleDTO.users_id}</td>
				<td>${simpleDTO.radius}</td>
			</tr>
		</c:forEach>
	</table>


<form action="<c:url value='/VolunteerServlet/Queries/Aggregate'/>" method="post">
	<input type="submit" value="Cities with Ideal volunteers willing to travel  > 20 miles"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Location</th>
			<th>Distance</th>
		</tr>
		<c:forEach items="${aggregateQuery}" var="aggregateDTO">
			<tr>
				<td>${aggregateDTO.preferred_location}</td>
				<td>${aggregateDTO.radius}</td>
			</tr>
		</c:forEach>
	</table>


<form action="<c:url value='/VolunteerServlet/Queries/Complex'/>" method="post">
	<input type="submit" value="Volunteer name of users with first name - Andrea"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
				<th>Volunteer Name</th>
			
		</tr>
		<c:forEach items="${complexQuery}" var="complexDTO">
			<tr>
				<td>${complexDTO.volunteer_name}</td>
				
			</tr>
		</c:forEach>
	</table>


  </body>
</html>
