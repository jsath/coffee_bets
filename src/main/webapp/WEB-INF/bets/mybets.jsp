<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                            <head>
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
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
                    <link rel="stylesheet" href="/css/stylesheet.css">
                <!DOCTYPE html>
                <html>


                    <meta charset="UTF-8">
                    <title>My Bets</title>
                    <link rel='icon' href='/imgs/coffee_icon.ico'>

                </head>

                <body>


                    <div id='tickerholder'>
                        <rssapp-ticker id="Xx5P2L2o3BBM2Iw7"></rssapp-ticker>
                        <script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>

                    </div>
                    <br>
                    <br>


                    <div class="nav">
                        <div class="nav-title">



                        </div>
                        <div class="Coffee-Title">

                            <a href='/dashboard'>
                                <h1><img width='400' src='/imgs/bets_clear.png'></h1>
                            </a>
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




                            <div class="betholder"
                                style="display:flex;flex-direction:row;width:80%;flex-wrap:wrap;gap:25px; margin-left: auto; margin-right:auto;">
                                <c:forEach var='bet' items='${user.bets}'>
                                    <div class='card card-hover text-dark shadow-lg'
                                        style="width:200px;margin-left:auto;margin-right:auto;margin-bottom:15px;background-color: #8C92AC;height:200px;">
                                        <c:if test='${bet.team == bet.game.home}'>
                                            <p class='text-center'>
                                                <c:out value='${bet.game.away}' /> vs <strong>
                                                    <c:out value='${bet.game.home}' />
                                                </strong>
                                            </p>
                                        </c:if>
                                        <c:if test='${bet.team == bet.game.away}'>
                                            <p class='text-center'><strong>
                                                    <c:out value='${bet.game.away}' />
                                                </strong> vs
                                                <c:out value='${bet.game.home}' />
                                            </p>
                                        </c:if>

                                        <div style='display:flex; flex-direction:row;justify-content:space-between;padding:4px;'>
                                            <p class='text-center'><strong>Stake</strong><br>
                                                <c:out value='${bet.amount}' />
                                            </p>

                                            <p class='text-center'><strong>Payout</strong><br>
                                                <c:out value='${bet.payout}' />
                                            </p>


                                        </div>
                                        <c:if test='${bet.game.isClosed == 1 }'>
                                        
                                        


                                            <c:if test='${bet.team == bet.game.winner }'>
                                            
                                            	<p class='text-center' style='color:#006400;'><strong><c:out value='${bet.game.winner}'/></strong></p>

                                                <p class='text-center' style='color:#006400;'>+<c:out value='${bet.payout}' /></p>
                                            </c:if>

                                            <c:if test='${bet.team != bet.game.winner }'>
                                            
                                            	<p class='text-center text-danger'><strong><c:out value='${bet.team}'/></strong><p>
                                                <p class='text-center text-danger'>-<c:out value='${bet.amount}'/></p>
                                                        
                                            </c:if>

                                        </c:if>


                                        <c:if test='${bet.game.isClosed == 0 }'>
                                            <p class='text-center'>Unsettled</p>
                                        </c:if>
                                        
                                    </div>

                                </c:forEach>

                            </div>





                        </div>

                    </div>
                </body>

                </html>