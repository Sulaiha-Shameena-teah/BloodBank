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
		<form action="/adduser" method="post" class="p-4 col-md-3 border border-primary mx-auto align-self-center">
				<h2>New User Register</h2> <br>
				<input class="form-control" type="text" name="userName" placeholder="User Name"/> <br>
				<input class="form-control" type="text" name="mobilenumber" placeholder="Mobile Number"/> <br>
				<input class="form-control" type="password" name="password" placeholder="Password" id="password"/> <br>
				<input class="form-control" type="password" name="conf_password" onchange="check()" placeholder="Confirm Password" id="cpassword"/> <br>
				<button class="btn btn-sm btn-primary" type="submit" disabled id="regbtn">Register</button> <br>
		</form>
	</div>		
</body>

<script>
	function check()
	{
		var x = document.getElementById('password').value;
		var y = document.getElementById('cpassword').value;
		if(x == y)
			{
				document.getElementById("regbtn").disabled = false;

			}
	}
</script>
</html>