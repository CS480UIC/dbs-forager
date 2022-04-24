<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read restaurant</title>
    
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
  <h1>Read restaurant</h1>
  	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<p style="color: red; font-weight: 900">${msg }</p>


<form action="<c:url value='/RestaurantServletRead'/>" method="post">
	restaurant ID    :<input type="text" name="rid" value="${form.rid}"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	<input type="submit" value="Read restaurant"/>
</form>


	<c:if test="${not empty restaurant }">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Restaurant ID</th>
				<th>Food Type</th>
				<th>address</th>
				<th>Safety rating</th>
	
			</tr>
			<tr>
				<td>${restaurant.restaurantId}</td>
				<td>${restaurant.foodType}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.safetyRating}</td>
		
			</tr>
		</table>
	</c:if>



  </body>
</html>


