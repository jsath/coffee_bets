<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Stadium</title>
</head>
<body>

<div>


<h1>Add Stadium</h1>

<form:form action="/stadiums/addstadium" method="post" modelAttribute="stadium">

        <form:label path="name">Stadium Name: </form:label><br>
        <form:input  path="name"/><br>
        <form:errors path="name" /><br>
        
        <form:label path="address">Address: </form:label><br>
        <form:input  path="address"/><br>
        <form:errors path="address" /><br>
        
        <input type="submit" value="Add Stadium" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>