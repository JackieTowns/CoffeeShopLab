<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="coffestyle.css"/> 
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<title>Coffee Shop</title>
</head>
<body>

<header> Welcome back ${preference}!!
<br/> 
<a href="/sessions/unset">Logout</a>
</header>
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