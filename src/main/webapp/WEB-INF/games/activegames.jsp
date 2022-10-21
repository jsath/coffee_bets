<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Dashboard</title>
                </head>

                <body>
                    <div class="main-box">
                        <div id='tickerholder'>
                            <rssapp-ticker id="Xx5P2L2o3BBM2Iw7"></rssapp-ticker><script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>
        
        </div>
                            <div class="nav-title">
                                <!-- <img src="/imgs/coffee_black_logo.png"> -->
                            </div>
                            <div class="Coffee-Title">
                                <h1> Coffee Bets</h1>

                            </div>
                            <h1> </h1>
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

                                <rssapp-wall id="0b6SDhsyDBvZ3sek"></rssapp-wall><script src="https://widget.rss.app/v1/wall.js" type="text/javascript" async></script>
                        </div>
                    </div>
                </body>

                </html>