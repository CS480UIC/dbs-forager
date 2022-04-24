<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Message</title>
    
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
  <h1>Read Message</h1>
<p style="color: red; font-weight: 900">${msg }</p>
  	<p style="color: red; font-weight: 900">${error}</p>
	<p style="color: blue; font-weight: 900">${success}</p>






<form action="<c:url value='/MessageServletRead'/>" method="post">
	Message ID    :<input type="text" name="rid" value="${form.rid}"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	<input type="submit" value="Read Message"/>
</form>


	<c:if test="${not empty interaction }">
		<h3 align="center">Result:</h3>
		<table border="1" width="70%" align="center">
			<tr>
				<th>interaction ID</th>
				<th>message ID</th>
				<th>reply of</th>
				<th>to id</th>
				<th>from id</th>
				<th>date created</th>
				<th>message content</th>
			</tr>
			<tr>
			
			
				<td>${interaction.interactionId}</td>
				<td>${interaction.messageId}</td>
				<td>${interaction.replyOf}</td>
				<td>${interaction.toId}</td>
				<td>${interaction.fromId}</td>
				<td>${interaction.dateCreated}</td>
				<td>${interaction.messageContent}</td>
		
		
			</tr>
		</table>
	</c:if>

  </body>
</html>
