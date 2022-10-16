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
                        <div class="ticker">
                        <rssapp-ticker id="0b6SDhsyDBvZ3sek"></rssapp-ticker><script src="https://widget.rss.app/v1/ticker.js" type="text/javascript" async></script>
                    </div>
                        <div class="nav">
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
                                <img src="/imgs/coffee_black_logo.png">
                                <button class="btn">Create Account</button>
                                <button class="btn">Login</button>
                            </div>
                            <div class="main-page">

                                <rssapp-wall id="0b6SDhsyDBvZ3sek"></rssapp-wall><script src="https://widget.rss.app/v1/wall.js" type="text/javascript" async></script>
                        </div>
                    </div>
                </body>

                </html>