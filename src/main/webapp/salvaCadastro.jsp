<%@page import="br.com.exemplo.jdbc.UsuarioDAO"%>
<%@page import="br.com.exemplo.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salvar Cadastro</title>
</head>
<body>
	<%
	String snome = request.getParameter("nome");
	String semail = request.getParameter("email");
	String ssenha = request.getParameter("senha");
	
	Usuario  usu = new Usuario();
	usu.setNome(snome);
	usu.setEmail(semail);
	usu.setSenha(ssenha);
	
	UsuarioDAO usuDAO = new UsuarioDAO();
	usuDAO.cadastro(usu);
	%>
	<h1>Salvo com Sucesso!</h1>
	<a href="cadastro.jsp">Novo Cadastro</a><br>
	<a href="UsuarioController">Lista de Usuários</a><br>
</body>
</html>