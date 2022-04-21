<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Read Donor</title>

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
	<h1>Read Donor</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/DonorServletRead'/>" method="post">
		<input type="hidden" name="method" value="regist" /> Donor ID :<input
			type="text" name="username" value="${form.username }" /> <span
			style="color: red; font-weight: 900">${errors.username }</span> <br />

		<input type="submit" value="Read Donor" />
	</form>

	<c:if test="${not empty donor }">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Donor ID</th>
				<th>Donor Type</th>
				<th>No. of times donated</th>
				<th>Average rating received</th>
				<th>User ID</th>
			</tr>
			<tr>
				<td>${donor.donorId}</td>
				<td>${donor.donorType}</td>
				<td>${donor.noOfTimesDonated}</td>
				<td>${donor.avgRatingReceived}</td>
				<td>${donor.usersId}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>
