<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Update Donor</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

</head>

<body>
	<h1>Update Donor</h1>
	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
	<form action="<c:url value='/DonorServletUpdate'/>" method="post">
		Donor ID :<input type="text" name="donorId" value="${form.donorId }" /><span
			style="color: red; font-weight: 900">${donorIdError}</span> <br />
		Update Donor Type：<input type="text" name="donorType"
			value="${form.donorType }" /> <br /> Update User ID ：<input
			type="text" name="userId" value="${form.userId }" /> <br /> Update
		No. of times donated ：<input type="text" name="timesDonated"
			value="${form.timesDonated }" /> <br /> Update Avg rating received：<input
			type="text" name="avgRating" value="${form.avgRating }" /> <br /> <input
			type="submit" value="Update Donor" />
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
