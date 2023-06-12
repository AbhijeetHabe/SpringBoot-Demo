<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
		<p style="text-align:center;color:${MSGCOLOR}"> ${MSG} </p>
		
		<h1 style="color:slateblue;text-align:center">LOGIN PAGE</h1>
		
		<form:form action="checkuser" method="post" class="form"
		modelAttribute="userobj">
			<div class="form-group">
				<form:label class="control-label" path="">Enter Your User Name</form:label>
				<form:input type="text" name="username" placeholder="User Name"
				class="form-control" path="username"></form:input> 
			</div>
			
			<div class="form-group">
				<form:label class="control-label" path="">Enter Your Password</form:label>
				<form:input type="password" name="password" placeholder="User Password"
				class="form-control" path="password"></form:input> 
			</div>
			
			<input type="submit" class="btn btn-block btn-info"
			value="LOGIN" name="btnLogin">
		</form:form>
		
		<p>Click <a href="reg">here</a> to register</p>
	</div>
</body>
</html>