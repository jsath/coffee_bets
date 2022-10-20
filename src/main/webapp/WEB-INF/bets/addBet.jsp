<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<script src="/apiservice/bet.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Bet</title>
</head>
<body>

<div>


<h1>Add Bet</h1>

<h2>Your Balance: $${wallet.coffeebeans}</h2>

			<div id="gamedetails">
			
			<!-- Dynamically rendered with api -->

			</div>




<form:form action="/bets/addbet" method="post" modelAttribute="bet">

<form:input path='apiId' type='hidden' value='${id}'></form:input>
<form:input path='game' type='hidden' value='${game.id}'></form:input>
<form:input path="user" type="hidden" value="${user_id}"/>


        <form:label path="amount">Amount: </form:label><br>
        <form:input id='amount' type="number" path="amount" min='1' max='${wallet.coffeebeans}' onchange="calculatePayout(${id})"/><br>
        <form:errors path="amount" /><br>
       
       	<form:label path='Team'>Team: </form:label>
        <form:select id='team' path="Team" onchange="calculatePayout(${id})">
        	<form:option id='home' value=''></form:option>
        	<form:option id='away' value=''></form:option>
        </form:select><br>
        <form:errors path="Team"/><br>
        
        
        
        
        <form:label path='payout'>Potential payout</form:label>
        <form:input path='payout' id='stake' readonly='true' type="text"/>
        

        <input type="submit" value="Add Bet"/>

</form:form>


<a href="/dashboard" ><button>Home</button></a>

</div>
<div style='position:fixed;bottom:0;'>
<p id='gameapi' style='font-size: 0px'>${id}</p>
</div>
</body>
</html>

