<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of All Products in cart</h2>

	<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>
				Cart id :${listValue.getCart().getCartId()} <br>
				Product id :${listValue.getItem().getId()} <br>
				Cart Item id :${listValue.getCartItemId()} <br>
				Name :${listValue.getItem().getName()} <br>
				Unit Price : ${listValue.getItem().getPrice()}<br>  
				quantity : ${listValue.getQuantity()}<br>
				Total Price : ${listValue.getValue()}<br>   

				<form action="/Cart" method="post">
				<input type="hidden" value=${listValue.getCartItemId()} name="cartItemId" />
				<input type="submit" value="Remove from Cart" />
				</form>
				</li><hr>
			</c:forEach>
		</ul>
		<form action="/Checkout" method"post">
		<input type="submit" value="Checkout"/>

	</c:if>





</body>
</html>