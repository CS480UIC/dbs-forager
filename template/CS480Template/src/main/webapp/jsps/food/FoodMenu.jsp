<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>CRUD operations for Food </h1>
    <br>
	<a href="<c:url value='/jsps/food/CreateFood.jsp'/>" target="_parent">Create Food</a> |&nbsp; 
	<a href="<c:url value='/jsps/food/ReadFood.jsp'/>" target="_parent">Read Food</a> |&nbsp;
	<a href="<c:url value='/FoodServlet/Update'/>" target="_parent">Update Food</a> |&nbsp;	 
	<a href="<c:url value='/FoodServlet/Delete'/>" target="_parent">Delete Food</a>	|&nbsp;
	<a href="<c:url value='/jsps/food/FoodQueries.jsp'/>" target="_parent">Queries</a>
	    
  </body>
</html>
