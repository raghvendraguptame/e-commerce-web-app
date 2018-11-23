<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		${account.name} <br>
		<form action="/Cart" method="post">
		    <input type="submit" value="Go to Cart"/>
		</form>
		<form action="/viewAllProducts" method="post">
        		    <input type="submit" value="Go to Products"/>
        		</form>
	</center>

</body>
</html>