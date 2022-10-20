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
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Add Bet</title>
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
                        <h4 class='text-center text-warning'>${user.wallet.coffeebeans}</h4>
						
                    </div>
                    <div class="main-body">
                        <div class="side-bar">
                            <a href='/dashboard'><img width='150' src="/imgs/coffee_dice_black.png"></a>
                            <button class="btn">Scores</button>
                            <a style='text-decoration:none;' href='/bets/activebets'><button class="btn">Active
                                    Bets</button></a>
                            <a style='text-decoration:none;' href='/bets/mybets'><button class="btn">Your
                                    Bets</button></a>
                            <a style='text-decoration:none;' href='/user/stats/${user.id}'><button class="btn">User Stats</button></a>
                            <a style='text-decoration:none;' href='/logout'><button class="btn">Logout</button></a>

                        </div>
                        <div class="main-page">
                        
                        
                                <h1>Add Bet</h1>

                                <h2>Your Balance: $${wallet.coffeebeans}</h2>

                                <div id="gamedetails">

                                    <!-- Dynamically rendered with api -->

                                </div>




                                <form:form action="/bets/addbet" method="post" modelAttribute="bet">

                                    <form:input path='apiId' type='hidden' value='${id}'></form:input>
                                    <form:input path='game' type='hidden' value='${game.id}'></form:input>
                                    <form:input path="user" type="hidden" value="${user_id}" />


                                    <form:label path="amount">Amount: </form:label><br>
                                    <form:input id='amount' type="number" path="amount" min='1'
                                        max='${wallet.coffeebeans}' onchange="calculatePayout(${id})" /><br>
                                    <form:errors path="amount" /><br>

                                    <form:label path='Team'>Team: </form:label>
                                    <form:select id='team' path="Team" onchange="calculatePayout(${id})">
                                        <form:option id='home' value=''></form:option>
                                        <form:option id='away' value=''></form:option>
                                    </form:select><br>
                                    <form:errors path="Team" /><br>




                                    <form:label path='payout'>Potential payout</form:label>
                                    <form:input path='payout' id='stake' readonly='true' type="text" />


                                    <input type="submit" value="Add Bet" />

                                </form:form>

                        </div>
                            <div style='position:fixed;bottom:0;'>
                                <p id='gameapi' style='font-size: 0px'>${id}</p>
                            </div>
                </body>

                </html>