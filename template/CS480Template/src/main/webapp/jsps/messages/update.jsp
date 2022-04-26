<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Message</title>
    
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
  
  





 <h1>Message Update</h1>	
	<p style="color: blue; font-weight: 900">${success}</p>
	<form action="<c:url value='/MessageServletUpdate'/>" method="post">
	 
	Interaction ID :<input type="text" name="iid" value="${form.iid }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	
	Update Message ID 	:<input type="text" name="messageId" value="${form.messageId }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>

	Update reply of ID	:<input type="text" name="replyOf" value="${form.replyOf }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	
	Update from user ID	:<input type="text" name="fromId" value="${form.fromId }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Update to user ID	：<input type="text" name="toId" value="${form.toId }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Update Date created	:<input type="date" name="dateCreated" value="${form.dateCreated}"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	
	Update Message Content：：<input type="text" name="mContent" value="${form.mContent }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	
	<br/>
	
	<input type="submit" value="Create Message"/>

</form>







  </body>
</html>
