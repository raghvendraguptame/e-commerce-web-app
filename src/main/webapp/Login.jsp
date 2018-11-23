<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<form action="/userAccount" method="post">
	<center>
		Username : <input type="text"  name="username"/> <br>
		Password : <input type="password"  name="password"/><br>		
		
		<input type="submit" value="Login"> <br>
	</center>
</form>
<center><a href="http://localhost:8080/forgotpassword"><input type="submit" value="Forgot Password"></a></center>
</body>
</html>