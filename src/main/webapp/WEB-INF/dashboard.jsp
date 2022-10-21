<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
            	<link href='https://fonts.googleapis.com/css?family=Bungee' rel='stylesheet'>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <script src="/apiservice/games.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Dashboard</title>
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
           
                           <a href='/dashboard'><h1><img width='400' src='/imgs/bets_clear.png'></h1></a>
                        </div>
                        <h4 class='text-center text-warning'>Balance: ${user.wallet.coffeebeans}</h4>
						
                    </div>
                    <div class="main-body">
                        <div class="side-bar">
                            <a href='/dashboard'><img width='150' src="/imgs/coffee_dice_black.png"></a>
                            <a style='text-decoration:none;' href='/bets/activebets'><button class="btn">Active Bets</button></a>
                            <a style='text-decoration:none;' href='/bets/mybets'><button class="btn">Betting History</button></a>
                            <a style='text-decoration:none;' href='/user/stats/${user.id}'><button class="btn">User Stats</button></a>
                            <a style='text-decoration:none;' href='/bets/leaderboard'><button class="btn">Leaderboard</button></a>
                            <a style='text-decoration:none;' href='/stadiums/all'><button class="btn">Stadiums</button></a>
                            <a style='text-decoration:none;' href='https://github.com/jsath/coffee_bets'><button class="btn">Our GitHub</button></a>
                            <a style='text-decoration:none;' href='/logout'><button class="btn">Logout</button></a>
                        </div>
                        <div class="main-page">
                        
                        


                        <div class="gamesByDate">
                                <input type="date" id="dateInput" />
                        </div>

                        <div id="games" style='display:flex; flex-direction: row;margin-top: 25px;flex-wrap:wrap-reverse;'>

                        </div>
                        
                        <rssapp-carousel id="Xx5P2L2o3BBM2Iw7"></rssapp-carousel><script src="https://widget.rss.app/v1/carousel.js" type="text/javascript" async></script>
                        
                        
                        
                        <table class='table table-dark text-center' style='width:400px; margin-left: auto; margin-right:auto;'>
                        
                        <thead>
                        <tr>
                        <th>Recent Payouts</th>
                        <th>User</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var='bet' items='${recentBets}'>
                        	<tr class='card-hover'>
                        	
                        	<td>$<c:out value='${bet.payout}'/></td>
                        	<td><c:out value='${bet.user.userName}'/></td>
  
                        
                       		</tr>
                        </c:forEach>
                        </tbody>
                        </table>
                        
                        

                     
                    </div>
                </div>
                    








                </body>
                <script>
                    var date = new Date();
                    console.log("hi there! local time -", date);

                    var month = date.getMonth() + 1;
                    var localDate = date.getFullYear() + "-" + month + "-" + date.getDate();
                    document.getElementById('dateInput').value = localDate;


                </script>


                </html>