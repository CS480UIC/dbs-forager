<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Food</title>
    
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
  <h1>Delete Food</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/FoodServlet/Delete'/>" method="post">
	Enter Food Id   :<input type="number" name="foodId" value="${form.food_id }"/>
	<span style="color: red; font-weight: 900">${errors.food_id }</span>
	<br/>
	<input type="submit" value="Delete Food"/>
</form>
<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
		<tr>
		<th>Food ID</th>
				<th>Food Type</th>
				<th>Food Name</th>
				<th>Calorie Tracker</th>
				<th>Donor Id</th>
		</tr>
		<c:forEach items="${food}" var="food">
			<tr>
				<td>${food.food_id}</td>
				<td>${food.food_type}</td>
				<td>${food.food_name}</td>
				<td>${food.calorie_tracker}</td>
				<td>${food.donor_id}</td>
			</tr>
		</c:forEach>

  </body>
</html>
