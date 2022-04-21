<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Read Receiver</title>

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
	<h1>Read Receiver</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/ReceiverServletRead'/>" method="post">
		Receiver ID :<input type="text" name="username"
			value="${form.username }" /> <br /> <input type="submit"
			value="Read Receiver" />
	</form>

	<c:if test="${not empty receiver }">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Receiver ID</th>
				<th>Receiver Type</th>
				<th>Average rating given</th>
				<th>User ID</th>
			</tr>
			<tr>
				<td>${receiver.receiverId}</td>
				<td>${receiver.receiverType}</td>
				<td>${receiver.avgRatingGiven}</td>
				<td>${receiver.usersId}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>
