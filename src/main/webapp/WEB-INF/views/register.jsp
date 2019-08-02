<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="coffestyle.css"/> 
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<title>Coffee Shop</title>
</head>
<body>

<header> 
		
		<c:if test="${ not empty preference }">
			<%-- For /register-result being added to the session --%> 
			<p> Welcome back ${preference}!!</p>
			<p> <a href="/admin">Admin</a></p> 
			<p><a href="/logout">Logout</a></p> 
		</c:if>
		
		<c:if test="${  empty user and empty preference }">
			<p> <a href="/register">Register Yourself</a></p>
			<p> <a href="/login">Log in</a></p>
		</c:if>
		
		<c:if test="${ not empty user }">
			<p>Welcome ${user.username}!!</p>
			<p> <a href="/">Home</a></p> 
			<p><a href="/logout">Logout</a></p>
		</c:if>

</header>


<h1>Register</h1>

<hr/>


<div id="registerForm"> 
<form action="/register-result" method="post" class="entireForm" >
	<p>UserName: <input type="text" name= "username" required/> </p>
	<p>Password: <input type="password" name= "password" required/> </p>
	<p> Your Name: <input type="text" name= "yourname" required/> </p>
	<p><input type="submit"/></p>
</form>
</div>


</body>
</html>