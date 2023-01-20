<%@page import="br.com.exemplo.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
</body>

<%
List<Usuario> listaResultado = (List<Usuario>)request.getAttribute("list");
%>
<table border = "1">
<tr bgcolor=#000080>
	<th>ID</th>
	<th>Nome</th>
	<th>Email</th>
	<th>Senha</th>
</tr>
<% 
for (Usuario u:listaResultado) {
%>	
<tr>
	<th><%=u.getId() %></th>
	<th><%=u.getNome() %></th>
	<th><%=u.getEmail() %></th>
	<th><%=u.getSenha() %></th>
</tr>
<% 
}
%>


</table>
</html>