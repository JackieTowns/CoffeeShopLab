<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="coffestyle.css"/> 
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP&display=swap" rel="stylesheet">

<title>Adding Food</title>
</head>
<body>

<header> Welcome back ${preference}!!
<br/> 
<a href="/sessions/unset">Logout</a>
</header>

<h1>Add to the Menu</h1>
<hr/> 

<div class="entireForm"> 
		<form method="post" >
		
			    <p>Name:<input name="name"></p>
			
			
			    <p>Description:<input name="description"></p>
			 
			    
			    <p>Price: <input name="price"></p> 
			    
			<p><button type="submit">Submit</button>
			<a href="/admin"><button type="button">Cancel</button></a></p>
		</form>
</div>
</body>
</html>