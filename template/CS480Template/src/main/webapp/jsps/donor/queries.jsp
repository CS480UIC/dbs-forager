<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Donor Queries</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

</head>

<body>
	<h1>Donor Queries</h1>
	<form action="<c:url value='/DonorServletSimpleQuery'/>" method="post">
		<input type="submit" value="Show donors ordered by rating" />
	</form>
	<c:if test="${not empty simpleRes}">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Donor ID</th>
				<th>Donor Type</th>
				<th>No. of times donated</th>
				<th>Average rating received</th>
				<th>User ID</th>
			</tr>
			<c:forEach items="${simpleRes}" var="donor">
				<tr>
					<td>${donor.donorId}</td>
					<td>${donor.donorType}</td>
					<td>${donor.noOfTimesDonated}</td>
					<td>${donor.avgRatingReceived}</td>
					<td>${donor.usersId}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<form action="<c:url value='/DonorServletAggQuery'/>" method="post">
		<input type="submit" value="Show count of all donor types" />
	</form>
	<c:if test="${not empty aggRes}">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Donor Type</th>
				<th>Count</th>
			</tr>
			<c:forEach items="${aggRes}" var="donor">
				<tr>
					<td>${donor.donorType}</td>
					<td>${donor.count}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />

	<form action="<c:url value='/DonorServletComplexQuery'/>" method="post">
		<input type="submit" value="Show all donors who are receivers as well" />
	</form>
	<c:if test="${not empty complexRes}">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>Donor ID</th>
				<th>Donor Type</th>
				<th>No. of times donated</th>
				<th>Average rating received</th>
				<th>User ID</th>
			</tr>
			<c:forEach items="${complexRes}" var="donor">
				<tr>
					<td>${donor.donorId}</td>
					<td>${donor.donorType}</td>
					<td>${donor.noOfTimesDonated}</td>
					<td>${donor.avgRatingReceived}</td>
					<td>${donor.usersId}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
