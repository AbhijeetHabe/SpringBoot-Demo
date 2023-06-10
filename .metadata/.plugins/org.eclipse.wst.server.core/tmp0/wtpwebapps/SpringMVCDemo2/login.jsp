<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Demo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form action="checkuser" method="post" class="form">
			<div class="form-group">
				<label class="control-label">Enter Your User Name</label>
				<input type="text" name="username" placeholder="User Name"
				class="form-control"> 
			</div>
			
			<div class="form-group">
				<label class="control-label">Enter Your Password</label>
				<input type="password" name="password" placeholder="User Password"
				class="form-control"> 
			</div>
			
			<input type="submit" class="btn btn-block btn-info"
			value="LOGIN" name="btnLogin">
		</form>
	</div>
</body>
</html>