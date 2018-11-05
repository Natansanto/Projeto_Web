<%@page import="br.com.flf.models.Livro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Foundation</title>
<link rel="stylesheet" href="css/estilo.css" />
</head>
<body>

	<h2 id="pesqLivro">Pesquisar Livro</h2>

	<nav id="menu">
	<ol>
		<li><a href="alterar-livro.html">Alterar</a></li>
		<li><a href="remover-livro.html">Remover</a></li>
		<li><a href="listar-livros.jsp">Listar</a></li>
		<li><a href="pesquisar-livros.jsp">Pesquisar</a></li>
		<li><a href="adiciona-livro.html">Adiciona</a></li>
	</ol>
	</nav>

	<form action="pesquisaLivro">
		Chave de pesquisa: <input type="text" name="key" />
		<button type="submit" value="Submit">Search</button>
	</form>
	<%
		try {
			List<Livro> livros = (List) request.getAttribute("lista_req");
			for (Livro livro : livros) {
	%>
	<%=livro.getTitulo()%>
	<%
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>