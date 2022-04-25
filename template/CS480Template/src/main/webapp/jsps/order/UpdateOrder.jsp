<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Order</title>
    
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
  <h1>Update Order</h1>
  <p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
<form action="<c:url value='/FoodOrderServlet/Update'/>" method="post">
	Order Id :<input type="number" name="orderId" value="${form.orderId }"/>
	<span style="color: red; font-weight: 900">${errors.orderId }</span>
	<br/>
	Pick-Up Location：<input type="text" name="pickUpLocation" value="${form.pickUpLocation }"/>
	<span style="color: red; font-weight: 900">${errors.pickUpLocation }</span>
	<br/>
	Drop Location：<input type="text" name="dropLocation" value="${form.dropLocation }"/>
	<span style="color: red; font-weight: 900">${errors.dropLocation }</span>
	<br/>
	Transporter Id :<input type="number" name="transporterId" value="${form.transporterId }"/>
	<span style="color: red; font-weight: 900">${errors.transporterId }</span>
	<br/>
	Food Id :<input type="number" name="foodId" value="${form.foodId }"/>
	<span style="color: red; font-weight: 900">${errors.foodId }</span>
	<br/>
	Pick-Up Time：<input type="date" name="pickUpTime" value="${form.pickUpTime }"/>
	<span style="color: red; font-weight: 900">${errors.pickUpTime }</span>
	<br/>
	Drop Time：<input type="date" name="dropTime" value="${form.dropTime }"/>
	<span style="color: red; font-weight: 900">${errors.dropTime }</span>
	<br/>
	Receiver Id ：<input type="number" name="receiverId" value="${form.receiverId }"/>
	<span style="color: red; font-weight: 900">${errors.receiverId }</span>
	<br/>
	Donor Id ：<input type="number" name="donorId" value="${form.donorId }"/>
	<span style="color: red; font-weight: 900">${errors.donorId }</span>
	<br/>
	<input type="submit" value="Update Order"/>
</form>


<h3 align="center">Preview</h3>
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
		<c:forEach items="${foodOrder }" var="foodOrder">
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
		</c:forEach>
  </body>
</html>
