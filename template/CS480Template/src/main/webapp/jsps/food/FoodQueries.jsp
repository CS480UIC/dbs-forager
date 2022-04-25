<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Queries</title>
    
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
  <h1>Food queries</h1>
<form action="<c:url value='/FoodServlet/Queries/Simple'/>" method="post">
	<input type="submit" value="Simple Query"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
		<th>Food ID</th>
				<th>Food Type</th>
				<th>Food Name</th>
				<th>Calorie Tracker</th>
				<th>Donor Id</th>
		</tr>
		<c:forEach items="${simpleQuery}" var="food">
			<tr>
				<td>${food.food_id}</td>
				<td>${food.food_type}</td>
				<td>${food.food_name}</td>
				<td>${food.calorie_tracker}</td>
				<td>${food.donor_id}</td>
			</tr>
		</c:forEach>
	</table>


<form action="<c:url value='/FoodServlet/Queries/Aggregate'/>" method="post">
	<input type="submit" value="Aggregate Query"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Food Type</th>
			<th>Calorie Tracker</th>
		</tr>
		<c:forEach items="${aggregateQuery}" var="aggregateDTO">
			<tr>
				<td>${aggregateDTO.food_type}</td>
				<td>${aggregateDTO.average}</td>
			</tr>
		</c:forEach>
	</table>


<form action="<c:url value='/FoodServlet/Queries/Complex'/>" method="post">
	<input type="submit" value="Complex Query"/>
</form>
<h3 align="center">Result</h3>
	<table border="1" width="70%" align="center">
		<tr>
				<th>Food Name</th>
				<th>Calories</th>
			
		</tr>
		<c:forEach items="${complexQuery}" var="complexDTO">
			<tr>
				<td>${complexDTO.food_name}</td>
				<td>${complexDTO.calorie_tracker}</td>
			</tr>
		</c:forEach>
	</table>


  </body>
</html>
