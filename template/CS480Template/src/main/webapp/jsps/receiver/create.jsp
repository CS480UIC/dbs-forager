<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Receiver Create</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">


</head>

<body>
	<h1>Receiver Create</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<p style="color: blue; font-weight: 900">${success }</p>
	<form action="<c:url value='/ReceiverServletCreate'/>" method="post">
		Receiver ID :<input type="text" name="donorId"
			value="${form.donorId }" /> <br /> Receiver Type：<input type="text"
			name="donorType" value="${form.donorType }" /> <br /> User ID ：<input
			type="text" name="userId" value="${form.userId }" /> <br /> <input
			type="submit" value="Create Receiver" />
	</form>
</body>
</html>
