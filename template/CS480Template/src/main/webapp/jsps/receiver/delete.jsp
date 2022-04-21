<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Delete Receiver</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

</head>

<body>
	<h1>Delete Receiver</h1>
	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>
	<form action="<c:url value='/ReceiverServletDelete'/>" method="post">
		Delete Receiver ID :<input type="text" name="receiverId"
			value="${form.receiverId }" /> <br /> <input type="submit"
			value="Delete Receiver" />
	</form>
	<h3 align="center">Preview</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Receiver ID</th>
			<th>Receiver Type</th>
			<th>Average rating given</th>
			<th>User ID</th>
		</tr>
		<c:forEach items="${receivers}" var="receiver">
			<tr>
				<td>${receiver.receiverId}</td>
				<td>${receiver.receiverType}</td>
				<td>${receiver.avgRatingGiven}</td>
				<td>${receiver.usersId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
