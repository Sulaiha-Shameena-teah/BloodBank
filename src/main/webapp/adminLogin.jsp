<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
	<div class="container text-center" style="height:100vh; padding-top: 25vh;">
	
		<form action="/adminLogin" method="post" class="p-4 col-md-3 border border-primary mx-auto align-self-center">
			<h2>Admin Login</h2> <br>
			<input class="form-control" type="text" name="username" placeholder="Admin Name"/> <br>
			<input class="form-control" type="password" name="password" placeholder="Password"/> <br>
			<button class="btn btn-sm btn-primary" type="submit">Login</button>
		</form>
		${comment}
	</div>	

</body>
</html>