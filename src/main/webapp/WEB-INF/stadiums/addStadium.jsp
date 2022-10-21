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
    <div id='tickerholder'>
        <rssapp-ticker id="Xx5P2L2o3BBM2Iw7"></rssapp-ticker><script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>

</div>

<div>


<h1>Add Stadium</h1>

<form:form action="/stadiums/addstadium" method="post" modelAttribute="stadium">

        <form:label path="location">Location: </form:label><br>
        <form:input  path="location"/><br>
        
        <form:label path="stadiumName">Stadium Name:</form:label><br>
        <form:input  path="stadiumName"/><br>
        
        <form:label path="imgFileName">Arena File Location:</form:label><br>
        <form:input path="imgFileName"/><br>
        
        <form:label type="number" path="capacity">Capacity:</form:label><br>
        <form:input path="capacity"/><br>
        
        <form:label path="teamName">Team Name:</form:label><br>
        <form:input path="teamName"/><br>
        
        <input type="submit" value="Add Stadium" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>