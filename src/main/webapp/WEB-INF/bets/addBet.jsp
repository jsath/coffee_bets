<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Bet</title>
</head>
<body>

<div>


<h1>Add Bet</h1>

<form:form action="/bets/addbet" method="post" modelAttribute="bet">

        <form:label path="amount">Amount: </form:label><br>
        <form:input type="number" path="amount"/><br>
        <form:errors path="amount" /><br>
        
        <form:label path="Team">Team: </form:label><br>
        <form:input path="Team"/><br>
        <form:errors path="Team" /><br>
        
        <form:input type="hidden" path="user" value="${user_id}"/>
        
       
        <input type="submit" value="Add Bet" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>