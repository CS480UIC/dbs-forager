<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Restaurant Queries</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

</head>

<body>
	<h1>Restaurant Queries</h1>
	<form action="<c:url value='/RestaurantServletSimpleQuery'/>" method="post">
		<input type="submit" value="Show restaurants by safety rating" />
	</form>
	
	<c:if test="${not empty simpleRes}">
		<h3 align="center">Preview</h3>
			<table border="1" width="70%" align="center">
					<tr>
					<th>Restaurant ID</th>
					<th>Food Type</th>
					<th>address</th>
					<th>Safety rating</th>
	
			</tr>
		<c:forEach items="${simpleRes}" var="restaurant">
			<tr>
				<td>${restaurant.restaurantId}</td>
				<td>${restaurant.foodType}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.safetyRating}</td>
		
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<br />
	<form action="<c:url value='/RestaurantServletAggQuery'/>" method="post">
		<input type="submit" value="Show count of all food types available in restaurants" />
	</form>
	<c:if test="${not empty aggRes}">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Restaurant's food Type</th>
				<th>Count</th>
			</tr>
			<c:forEach items="${aggRes}" var="restaurant">
				<tr>
					<td>${restaurant.foodType}</td>
					<td>${restaurant.count}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />

	<form action="<c:url value='/RestaurantServletComplexQuery'/>" method="post">
		<input type="submit" value="Show all resturants whose owners are receivers as well." />
	</form>
	
	
	
	<c:if test="${not empty complexRes}">
			<h3 align="center">Preview</h3>
			<table border="1" width="70%" align="center">
					<tr>
					<th>Restaurant ID</th>
					<th>Food Type</th>
					<th>address</th>
					<th>Safety rating</th>
	
			</tr>
		<c:forEach items="${complexRes}" var="restaurant">
			<tr>
				<td>${restaurant.restaurantId}</td>
				<td>${restaurant.foodType}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.safetyRating}</td>
		
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	
	

</body>
</html>