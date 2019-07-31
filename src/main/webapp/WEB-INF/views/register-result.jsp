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

<p id="thanks"> Thank you for registering, ${ user.yourname}!</p>

</body>
</html>