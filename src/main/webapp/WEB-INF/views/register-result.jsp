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
		
		<p> <a href="/">Home</a></p> 
		<p> <a href="/admin">Admin</a></p>
		<p><a href="/logout">Logout</a></p>
		 

</header>
<hr/>

<p id="thanks"> Thank you for registering, ${ user.yourname}!</p>

</body>
</html>