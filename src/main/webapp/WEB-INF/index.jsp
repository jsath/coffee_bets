<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/stylesheet.css">
                <script src="/apiservice/ticker.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Coffee Bets</title>
                    <link rel='icon' href='/imgs/coffee_icon.ico'>
                    
                </head>

                <body>
                    <div class="main-box">
                        <div class="ticker">
                            <rssapp-ticker id="tufwi3dFkKc1sOoP"></rssapp-ticker><script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>

						</div>
            	        </div>
                        <div class="nav">
                            <div class="nav-title">
                                <!-- <img src="/imgs/coffee_black_logo.png"> -->
                            </div>
                            <div class="Coffee-Title">
                                <h1><img width='400' src='/imgs/bets_clear.png'></h1>

                            </div>
                            <h1> </h1>
                        </div>
                        <div class="main-body">
                            <div class="side-bar">
                                <img width='150' src="/imgs/coffee_dice_black.png">
                                <a href="/register" style="text-decoration:none;"><button class="btn">Create Account</button></a>
                                <a href="/login" style="text-decoration:none;"><button class="btn">Log In</button></a>
                            </div>
                            <div class="main-page">

                                <rssapp-wall id="tufwi3dFkKc1sOoP"></rssapp-wall><script src="https://widget.rss.app/v1/wall.js" type="text/javascript" async></script>
                        </div>
                    </div>
                </body>

                </html>