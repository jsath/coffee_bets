<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <script src="/apiservice/testing.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Dashboard</title>
                </head>

                <body>
                
                <!-- Updated Ticker populated with testing.js -->
                    <div class="main-box">
                        <div class="ticker">
    					<div class="row">
        					<div class="col-md-12">
            					<div class="d-flex justify-content-between align-items-center">
                					<div id="tickerholder" class="d-flex flex-row flex-grow-1 flex-fill align-items-center py-2 text-white px-1 news"></div>
            						</div>
       							 </div>
   							 </div>
						
						</div>
            		</div>
            
                        <div class="nav">
                            <div class="nav-title">
                            
                            </div>
                            <div class="Coffee-Title">
                                <h1>Coffee Bets</h1>

                            </div>
                            <h1> </h1>
                        </div>
                        <div class="main-body">
                            <div class="side-bar">
                                <img src="/imgs/coffee_black_logo.png">
                                <button class="btn">Scores</button>
                                <button class="btn">Place Bets</button>
                                <button class="btn">Your Bets</button>
                                <button class="btn">Tokens</button>
                                <button class="btn">Stadiums</button>
                                <button class="btn">All Bets</button>
                                <button class="btn">Creators</button>
                                <button class="btn">Settings</button>
                                <a href="/logout" style="text-decoration:none;"><button class="btn">Log Out</button></a>
                            </div>
                            <div class="main-page">

                                <rssapp-magazine id="0b6SDhsyDBvZ3sek"></rssapp-magazine><script src="https://widget.rss.app/v1/magazine.js" type="text/javascript" async></script>
                        </div>
                    </div>
                </body>

                </html>