<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coffee Shop</title>
</head>
<body>

<h1>Products</h1>
		<table class="table">
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
		
		<p> <a href="/register">Register Yourself</a></p>


</body>
</html>