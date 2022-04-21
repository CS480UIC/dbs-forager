<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Delete Donor</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

</head>

<body>
	<h1>Delete Donor</h1>
	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
	<form action="<c:url value='/DonorServletDelete'/>" method="post">
		Delete Donor ID :<input type="text" name="donorId"
			value="${form.donorId }" /> <br /> <input type="submit"
			value="Delete Donor" />
	</form>
	<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Donor ID</th>
			<th>Donor Type</th>
			<th>No. of times donated</th>
			<th>Average rating received</th>
			<th>User ID</th>
		</tr>
		<c:forEach items="${donors}" var="donor">
			<tr>
				<td>${donor.donorId}</td>
				<td>${donor.donorType}</td>
				<td>${donor.noOfTimesDonated}</td>
				<td>${donor.avgRatingReceived}</td>
				<td>${donor.usersId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
