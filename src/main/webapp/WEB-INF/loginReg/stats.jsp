<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
               	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>
            
                <html lang="en">
                <!DOCTYPE html>


                <head>
                    <meta charset="UTF-8">
                    <title>Stats</title>
                    <link rel='icon' href='/imgs/coffee_icon.ico'>

                </head>

                <body>
                 <div id='tickerholder'>
                                    <rssapp-ticker id="Xx5P2L2o3BBM2Iw7"></rssapp-ticker><script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>
                
                </div>
                <br>
                <br>
                                

                    <div class="nav">
                        <div class="nav-title">
                        
                        

                        </div>
                        <div class="Coffee-Title">
           
                           <a href='/dashboard'><h1><img class='card-hover' width='400' src='/imgs/bets_clear.png'></h1></a>
                        </div>
                        <h4 class='text-center text-warning'>Balance: ${user.wallet.coffeebeans}</h4>
						
                    </div>
                    <div class="main-body">
                        <div class="side-bar">
                            <a href='/dashboard'><img class='card-hover' width='150' src="/imgs/coffee_dice_black.png"></a>
                            <a style='text-decoration:none;' href='/bets/activebets'><button class="btn">Active Bets</button></a>
                            <a style='text-decoration:none;' href='/bets/mybets'><button class="btn">Betting History</button></a>
                            <a style='text-decoration:none;' href='/user/stats/${user.id}'><button class="btn">User Stats</button></a>
                            <a style='text-decoration:none;' href='/bets/leaderboard'><button class="btn">Leaderboard</button></a>
                            <a style='text-decoration:none;' href='/stadiums/all'><button class="btn">Stadiums</button></a>
                            <a style='text-decoration:none;' href='https://github.com/jsath/coffee_bets'><button class="btn">Our GitHub</button></a>
                            <a style='text-decoration:none;' href='/logout'><button class="btn">Logout</button></a>
                        </div>
                        <div class="main-page">
                        
                        							<div style='width:530px;margin-left: auto;'>

  									<div class="p-2 justify-content end"><a style='width:fit-content;' href='/dashboard'><button class='text-center card-hover btn-primary'>Back</button></a></div>

							</div>
                        
                        
                        <div class='card text-center' style='width:350px;margin-left: auto; margin-right:auto;display:flex;flex-direction:column;flex-wrap:wrap;'>
                        
                        <h2><strong>Summary</strong></h2>
                        
                        <p>Total Beans won:<strong class='text-success'>$<c:out value='${winnings}'/></strong> </p>
                        <p>Total Beans wagered: $<c:out value='${totalBet}'/></p>
                        <p>Current Balance: $<c:out value='${user.wallet.coffeebeans}'/></p>
                        </div>
             	           <h1 class='text-center'>Your Recent Wins</h1>
             		 <table class='table table-dark text-center' style='width:350px; margin-left: auto; margin-right:auto;margin-top:2px;'>
                        
                        <thead>
                        <tr>
                        <th>Wager</th>
                        <th>Winnings</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var='bet' items='${recentWinnings}'>
                        	<tr class='card-hover'>
                        	<c:if test='${bet.team == bet.game.winner}'>
                        	<td><c:out value='${bet.amount}'/></td>
                        	<td><c:out value='+${bet.payout}'/></td>
                        	</c:if>
                       		</tr>
                        </c:forEach>
                        </tbody>
                    	</table>
                     </div>


</body>
</html>