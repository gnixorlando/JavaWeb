    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<form action="salvaCadastro" method = "post">
	<label>Nome: </label>
	<input type= "text" name = "nome">
	<label>Email: </label>
	<input type= "text" name = "email">
	<label>Senha: </label>
	<input type = "password" name = "senha">
	
	<input type= "submit" value = "Cadastrar">
</form>
	
</body>
</html>