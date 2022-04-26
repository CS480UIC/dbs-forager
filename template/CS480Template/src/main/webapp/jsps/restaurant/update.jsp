<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update restaurant</title>
    
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
  <h1>Update restaurant</h1>
  
  	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>





<form action="<c:url value='/RestaurantServletUpdate'/>" method="post">
	Restaurant ID    :<input type="text" name="rid" value="${form.rid }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Restaurant safety rating ：<input type="text" name="rname" value="${form.rname }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	
	Restaurant address   :<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Restaurant food type ：<input type="text" name="foodtype" value="${form.foodtype }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	
	<input type="submit" value="Update Restaurant"/>

</form>


<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
	<tr>
				<th>Restaurant ID</th>
				<th>Food Type</th>
				<th>address</th>
				<th>Safety rating</th>
	
			</tr>
		<c:forEach items="${restaurants}" var="restaurant">
			<tr>
				<td>${restaurant.restaurantId}</td>
				<td>${restaurant.foodType}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.safetyRating}</td>
		
			</tr>
		</c:forEach>
	</table>



	
		




  </body>
</html>
