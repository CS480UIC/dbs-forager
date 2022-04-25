<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Order</title>
    
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
  <h1>Read Order</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/FoodOrderServlet/Read'/>" method="post">
	Enter Order Id    :<input type="number" name="orderId" value="${form.orderId }"/>
	<span style="color: red; font-weight: 900">${errors.orderId }</span>
	<br/>
<%-- 	Password：<input type="password" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Email	：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/> --%>
	<input type="submit" value="Read Order"/>
</form>

<c:if test="${not empty foodOrder }">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
			<th>Order ID</th>
				<th>Pick up Location</th>
				<th>Drop Location</th>
				<th>Transporter Id</th>
				<th>Food Id</th>
				<th>Pick up time</th>
				<th>Drop Time</th>
				<th>Donor ID</th>
				<th>Receiver ID</th>
			</tr>
			<tr>
				<td>${foodOrder.order_id}</td>
				<td>${foodOrder.pick_up_location}</td>
				<td>${foodOrder.drop_location}</td>
				<td>${foodOrder.transporter_id}</td>
				<td>${foodOrder.food_id}</td>
				<td>${foodOrder.pick_up_time}</td>
				<td>${foodOrder.drop_time}</td>
				<td>${foodOrder.donor_id}</td>
				<td>${foodOrder.receiver_id}</td>
			</tr>
		</table>
	</c:if>
  </body>
</html>
