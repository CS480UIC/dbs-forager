<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Volunteer Create</title>
    
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
  <h1>Volunteer Create</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/VolunteerServlet/Add'/>" method="post">
	Volunteer/User ID    :<input type="text" name="users_id" value="${form.users_id }"/>
	<span style="color: red; font-weight: 900">${errors.users_id }</span>
	<br/>
	Volunteer Name    :<input type="text" name="volunteer_name" value="${form.volunteer_name }"/>
	<span style="color: red; font-weight: 900">${errors.volunteer_name }</span>
	<br/>
	Preferred Location   ：<input type="text" name="preferred_location" value="${form.preferred_location }"/>
	<span style="color: red; font-weight: 900">${errors.preferred_location }</span>
	<br/>
	Location Radius	：<input type="text" name="location_radius" value="${form.location_radius }"/>
	<span style="color: red; font-weight: 900">${errors.location_radius }</span>
	<br/>
	Availability Date	：<input type="text" name="availability_date" value="${form.availability_date }"/>
	<span style="color: red; font-weight: 900">${errors.availability_date }</span>
	<br/>
	
	<input type="submit" value="Create Volunteer"/>
</form>
  </body>
</html>
