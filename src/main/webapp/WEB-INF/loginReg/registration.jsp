<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel='icon' href='/imgs/coffee_icon.ico'>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"> 
<link rel="stylesheet" href="/css/stylesheet2.css">

</head>
	<body>
	<nav class="text-center" class="navbar navbar-light bg-light">
    <a href='/'><h1><img width='400' src='/imgs/bets_clear.png'></h1></a>
</nav> <br>

<section class="vh-100" ><!-- style="background-color: #eee;"> -->
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <h4 class="text-center">Create Account</h4>

                <form:form action="/register" method="post" modelAttribute="user" class="mx-1 mx-md-4 text-center">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <form:input path="userName" type="text" id="form3Example1c" class="form-control" />
                      <form:label path="userName" class="form-label" for="form3Example1c">Your Name</form:label>
                      <form:errors path="userName" class="text-danger"/><br>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <form:input path="email"  type="email" id="form3Example3c" class="form-control" />
                      <form:label path="email" class="form-label" for="form3Example3c">Your Email</form:label>
                      <form:errors path="email" class="text-danger"/><br>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <form:input path="password" type="password" id="form3Example4c" class="form-control" />
                      <form:label path="password" class="form-label" for="form3Example4c">Password</form:label>
                      <form:errors path="password" class="text-danger"/><br>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <form:input path="confirm" type="password" id="form3Example4cd" class="form-control" />
                      <form:label path="confirm" class="form-label" for="form3Example4cd">Confirm Password</form:label>
                      <form:errors path="confirm" class="text-danger"/><br>
                    </div>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" value="Register" class="btn btn-primary btn-lg">Create</button>
                  </div>

                </form:form>

              </div>
              <div class="col"><!-- class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2" -->
					<p>Thank you for joining us at Coffee Bets. We are excited to share with you our Full Stack Java Project. We have created a fully functioning betting website using tools and techniques taught at Coding Dojo. This website was built purely for learning purposes and was an absolute blast. The API that we used was a free version and so some game details may not be 100% accurate. Please enjoy and feel free to pass on any feedback to the creators.</p>
              

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

	</body>
</html>