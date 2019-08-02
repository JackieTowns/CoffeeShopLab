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

<h1>Products</h1>
<hr/>

<div class="entireForm"> 
		<table>
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
					<td> <a href="/admin/delete?id=${theProducts.id }">Delete Item</a></td> 
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>	
		<p> <a href="/add" id="addMenu">Add to Menu</a></p>	

</body>
</html>