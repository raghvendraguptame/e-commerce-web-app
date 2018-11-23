<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>List of All Products</h2>

	<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li><form action="/Cart" method="post">
				${listValue}<input type="hidden" value="${listValue.id}" name="productId"></input>
				<input type="submit" value="Add to Cart"/>
				</form></li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>