<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Wallet</title>
</head>
<body>

<div>


<h1>Add Wallet</h1>

<form:form action="/wallets/addwallet" method="post" modelAttribute="wallet">

        <form:label path="usd">Dollars: </form:label><br>
        <form:input  path="usd"/><br>
        <form:errors path="usd" /><br>
        
        <form:label path="coffeebeans">Coffee Beans: </form:label><br>
        <form:input  path="coffeebeans"/><br>
        <form:errors path="coffeebeans" /><br>
          
        <input type="submit" value="Add Currency" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>