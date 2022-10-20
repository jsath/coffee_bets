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
                <script src="/apiservice/ticker.js"></script>
                <script src="/apiservice/games.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>My Bets</title>

</head>
<body>
	<div class="nav">

		<div class="Coffee-Title">
			<a href='/dashboard'><h1 class="text-center"><img width='400' src='/imgs/bets_clear.png'></h1></a>
		</div>
	</div>
	<div class="main-body">
		<div class="side-bar">
			<a href='/dashboard'><img width='150' src="/imgs/coffee_dice_black.png"></a>
			<button class="btn">Scores</button>
			<a style='text-decoration:none;' href='/bets/activebets'><button class="btn">Active
					Bets</button></a>
			<a style='text-decoration:none;' href='/bets/mybets'><button class="btn">Your
					Bets</button></a>
			<button class="btn">Tokens</button>
			<a style='text-decoration:none;' href='/logout'><button class="btn">Logout</button></a>

		</div>
		<div class="main-page">



<div class="betholder" style="display:flex;flex-direction:row;width:80%;flex-wrap:wrap;gap:25px">
<c:forEach var='bet' items='${user.bets}'>
<div class='card' style="width:250px;margin-left:auto;margin-right:auto;margin-bottom:25px;">
<p>Amount: <c:out value='${bet.amount}'/></p>
<p>Potential Payout <c:out value='${bet.payout}'/> </p>
<p>Team <c:out value='${bet.team}'/> </p>

<p>Away: <c:out value='${bet.game.away}'/> </p>

<p>Home: <c:out value='${bet.game.home}'/> </p>
</div>

</c:forEach>

</div>





</div>

</body>
</html>