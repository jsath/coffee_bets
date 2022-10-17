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

        <form:label path="homeTeam">Home Team: </form:label><br>
        <form:input  path="homeTeam"/><br>
        <form:errors path="homeTeam" /><br>
        
        <form:label path="awayTeam">Away Team: </form:label><br>
        <form:input  path="awayTeam"/><br>
        <form:errors path="awayTeam" /><br>
        
        <form:label path="homeTeamScore">Home Team Score: </form:label><br>
        <form:input  path="homeTeamScore"/><br>
        <form:errors path="homeTeamScore" /><br>
        
        <form:label path="awayTeamScore">Away Team Score: </form:label><br>
        <form:input  path="awayTeamScore"/><br>
        <form:errors path="awayTeamScore" /><br>
        
        <form:label path="homeTeamOdds">Home Team Odds: </form:label><br>
        <form:input  path="homeTeamOdds"/><br>
        <form:errors path="homeTeamOdds" /><br>
        
        <form:label path="awayTeamOdds">Away Team Odds: </form:label><br>
        <form:input  path="awayTeamOdds"/><br>
        <form:errors path="awayTeamOdds" /><br>
        
        <form:label path="gameDay">Game Day: </form:label><br>
        <form:input type="date" path="gameDay"/><br>
        <form:errors path="gameDay" /><br>
        
        
        
        <input type="submit" value="Add Game" />

</form:form>

<a href="/dashboard" ><button>Home</button></a>

</div>

</body>
</html>