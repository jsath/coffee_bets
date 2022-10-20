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

<link rel="stylesheet" href="/css/stylesheet2.css">


<link rel="stylesheet" href="/css/stylesheet2.css">

                <script src="/apiservice/testing.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!-- <link rel="stylesheet" href="/css/stylesheet.css"> -->

<head>
<body class="p-3 mb-2 bg-gradient-success text-white">



<nav class="text-center" class="navbar navbar-light bg-light">
  <span class="text-center" class="navbar-text">
    Coffee Bets
  </span>
</nav> <br>

<div class="container d-flex justify-content-evenly mt-3">
  


<form:form action="/login" method="post" modelAttribute="loginUser" class = "w-25% p-3">
<div class="login"><h1 class="text-center">Login</h1></div> <br>

  <!-- Email input -->
  <div class="form-outline mb-4">
    <form:input path="email" type="email" id="form2Example1" class="form-control" />
    <form:label  path="email" class="form-label" for="form2Example1">Email address</form:label>
    <form:errors path="email" class="text-danger"/>
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">

    <form:input path="password" type="password" id="form2Example2" class="form-control"/>

    <form:label path="password"  class="form-label" for="form2Example2">Password</form:label>
    <form:errors path="password" class="text-danger"/>
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Remember me </label>
      </div>
    </div>

    <div class="col">
      <!-- Simple link -->
      <a href="#!">Forgot password?</a>
    </div>
  </div>

  <!-- Submit button -->
  <input type="submit" value="Sign in" class="btn btn-primary btn-block mb-4"/>

  <!-- Register buttons -->
  <div class="text-center">
    <p>Not a member? <a href="/register">Register</a></p>
   </div>
</form:form>


</div>
</body>
</head>


