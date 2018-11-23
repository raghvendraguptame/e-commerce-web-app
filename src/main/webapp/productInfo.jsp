<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/updateProduct" method="post">
	<center>
		ID : <input type="text"  name="id" value= ${product.id} ></input> <br>
		Name : <input type="text" name="name" value= ${product.name} ></input> <br>
		Price : <input type="text" name="price" value= ${product.price} ></input><br>
		
		<input type="submit" value="Update Product Info">
	</center>
</form>
</body>
</html>