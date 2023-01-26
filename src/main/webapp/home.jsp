<%@page import="br.com.exemplo.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<h1>Learning Java Web</h1>

<%
Usuario usuAutenticado = (Usuario) session.getAttribute("usuAutenticado");
out.print("Bem vindo(a)! " + usuAutenticado.getNome());

 %>
</body>
</html>