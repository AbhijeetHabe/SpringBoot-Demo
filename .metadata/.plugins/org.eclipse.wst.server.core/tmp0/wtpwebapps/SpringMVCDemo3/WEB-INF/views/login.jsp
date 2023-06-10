<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<form:form action="checkuser" method="post" class="form"
		modelAttribute="userobj">
			<div class="form-group">
				<form:label class="control-label" path="">Enter Your User Name</form:label>
				<form:input type="text" name="username" placeholder="User Name"
				path="username" class="form-control"></form:input> 
			</div>
			
			<div class="form-group">
				<form:label class="control-label" path="">Enter Your Password</form:label>
				<form:input type="password" name="password" placeholder="User Password"
				path="password" class="form-control"></form:input>
			</div>
			
			<input type="submit" class="btn btn-block btn-info"
			value="LOGIN" name="btnLogin">
		</form:form>
	</div>
</body>
</html>