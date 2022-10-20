<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Game</title>
</head>
<body>

<div>


<h1>Add Game</h1>

<form:form action="/games/addgame" method="post" modelAttribute="game">

        <form:label path="stadium">Stadium: </form:label><br>
        <form:input type="number" path="stadium"/><br>
        <form:errors path="stadium" /><br>
        
         <form:label path="apiId">Stadium: </form:label><br>
        <form:input type="apiId" path="apiId"/><br>
        <form:errors path="apiId" /><br>
        
        
        
        
        
        <input type="submit" value="Add Game" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>