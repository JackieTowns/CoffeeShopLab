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
		
	<%-- 	<c:if test="${ empty preference }">
			<p> <a href="/register">Register Yourself</a></p>
			<p> <a href="/login">Log in</a></p>
		</c:if> --%>
		
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
			<p> <a href="/admin">Admin</a></p> 
			<p><a href="/logout">Logout</a></p>
		</c:if>
		
</header>

${ error }

<h1>Products</h1>
<hr/>

<div id="registerAdmin"> 
</div> 


		<table id="table">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="theProducts" items="${products}">
				<tr>
					<td><a href="/index?id=${theProducts.id}">${theProducts.name}</a></td>
					<td>${theProducts.description}</td>
					<td>${theProducts.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	
	
	<c:if test="${  empty user and empty preference }">
			<p id="AdminMessage">Login or Register to see the Admin page!</p>
		</c:if>
		
		

</body>
</html>