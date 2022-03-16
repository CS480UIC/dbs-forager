<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update User</title>
    
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
  <h1>Update User</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Update User Name    :<input type="text" name="username" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Update Password：<input type="password" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Update Name of Organization	：<input type="text" name="name_of_organization" value="${form.name_of_organization }"/>
	<span style="color: red; font-weight: 900">${errors.name_of_organization }</span>
	<br/>
	Update Organization ID	：<input type="text" name="org_id" value="${form.org_id }"/>
	<span style="color: red; font-weight: 900">${errors.org_id }</span>
	<br/>
	Update First Name	：<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.name_of_organization }</span>
	<br/>
	Update Last Name 	：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Update Email ID	：<input type="text" name="email_id" value="${form.email_id }"/>
	<span style="color: red; font-weight: 900">${errors.email_id }</span>
	<br/>
	Update Contact Number	：<input type="text" name="contact_number" value="${form.contact_number }"/>
	<span style="color: red; font-weight: 900">${errors.contact_number }</span>
	<br/>
	Update Address	：<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	<input type="submit" value="Update User"/>
</form>
  </body>
</html>