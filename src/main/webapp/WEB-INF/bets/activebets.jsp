<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <script src="/apiservice/cashout.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Active Bets</title>


<h3 class='text-center' style='color:red;'>Balance: ${wallet.coffeebeans}</h3>
<a href='/dashboard' style='text-decoration:none;'><button>Home</button></a>



</head>
<body>








<c:forEach var='bet' items='${bets}'>




<div class="card" style='width:600px;margin-left:auto;margin-right:auto;margin-top:50px;'>


<h2>${bet.game.away} vs ${bet.game.home}</h2>

<h4 id='team'>Your Team: <c:out value='${bet.team}'/> </h4>

<p>Wager <c:out value='${bet.amount}'/></p>

<c:if test='${bet.game.winner == null }'>
<h1>Bet In progress</h1>
</c:if>

<!-- If the game winner is updated -->

<c:if test='${bet.game.winner != null }'>


<!-- If user bet on correct team show them cashout button -->

<c:if test='${bet.game.winner == bet.team }'>

<form action="/bets/close/bet/${bet.id}" method="post">
<input type="hidden" name="_method" value="put"/>
<button class='btn btn-success'>Claim $${bet.payout}</button>
</form>

</c:if>

<!-- If user bet on wrong team show them close ticket button -->

<c:if test='${bet.game.winner != bet.team }'>


<form action="/bets/close/bet/${bet.id}" method="post">
<input type="hidden" name="_method" value="put"/>
<button class='btn btn-warning'>Close ticket</button>
</form>

</c:if>


</c:if>

<c:if test='${bet.game.winner == null}'>


<button class='btn btn-secondary' onclick='payDay(${bet.apiId})'>Check for scores</button>


<form:form action="/games/edit/${bet.game.id}" method="post" modelAttribute="game">
<input type="hidden" name="_method" value="put"/>

<div class='hiddenform' style='height:5px;'>
		<form:input id='${bet.apiId}' type='hidden' path="winner" value=''/><br>
		
		<form:input type='hidden' path="apiId" value='${bet.apiId}'/><br>
		
		<form:input type='hidden' path="home" value='${bet.game.home}'/><br>
		<form:input id='homeScore' type='hidden' path="homeScore" value=''/><br>
		
		<form:input type='hidden' path="away" value='${bet.game.away}'/><br>
		<form:input id='awayScore' type='hidden' path="awayScore" value=''/><br>
		
	
		<form:input type='hidden' path="stadium" value='${bet.game.stadium.id}'/><br>
		
		<form:input type='hidden' path="isClosed" value='1'/><br>
	</div>

        <input type="submit" value="Verify Data" class="btn btn-primary"/>
</form:form>

<p>If game is over, and you can't claim/close ticket, please check for scores then verify data</p>

</div>

</c:if>


</c:forEach>



</body>
</html>