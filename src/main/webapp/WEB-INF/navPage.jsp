<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col"><nav class="nav flex-column">
                <a class="nav-link active" aria-current="page" href="#">Not Sure</a>
                <a class="nav-link" href="#">Scores</a>
                <a class="nav-link" href="#">PLACE BETS</a>
                <a class="nav-link" href="#">SEE BETS</a>
                <a class="nav-link" href="#">EDIT PROFILE</a>
                <a class="nav-link" href="#">PURCHASE TOKENS</a><br/>
                <a href="/logout">Logout</a>
                </nav></div>
            <div class="col">News/whatever is clicked on</div>
        </div>

    </div>
</body>
</html>