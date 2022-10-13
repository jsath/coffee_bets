<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/stylesheet.css">

</head>
<body>


<div class="holder">

<div class="main">

<h1>Register</h1>

<form:form action="/register" method="post" modelAttribute="user">

        <form:label path="userName">Username: </form:label><br>
        <form:input path="userName"/><br>
        <form:errors path="userName" class="text-danger"/><br>
        
        <form:label path="email">Email: </form:label><br>
        <form:input path="email"/><br>
        <form:errors path="email" class="text-danger"/><br>
        
        <form:label path="password">Password: </form:label><br>
        <form:input type="password" path="password"/><br>
        <form:errors path="password" class="text-danger"/><br>
        
       	<form:label path="confirm">Confirm Password: </form:label><br>
        <form:input type="password" path="confirm"/><br>
        <form:errors path="confirm" class="text-danger"/><br>
        
       
        <input type="submit" value="Register" class="btn btn-primary"/>

</form:form>

</div>

<div class="second">

<h1>Login</h1>

<form:form action="/login" method="post" modelAttribute="loginUser">

        
        <form:label path="email">Email: </form:label><br>
        <form:input path="email"/><br>
        <form:errors path="email" class="text-danger"/><br>
        
        <form:label path="password">Password: </form:label><br>
        <form:input type="password" path="password"/><br>
        <form:errors path="password" class="text-danger"/><br>
        

       
        <input type="submit" value="Login" class="btn btn-primary"/>

</form:form>


</div>

</div>









</body>
</html>