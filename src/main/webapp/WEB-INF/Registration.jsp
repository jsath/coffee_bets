<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>

    <div class="nav">
        <h1 class="nav-title">Profile</h1>
        <ul class="nav-links">
                    <li><button class="btn">Settings</button></li>
                    <li><button class="btn">Creators</button></li>
                    <li><button class="btn">Sign Out</button></li>
        </ul>
    </div>

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
</body>
</html>

</body>
</html>