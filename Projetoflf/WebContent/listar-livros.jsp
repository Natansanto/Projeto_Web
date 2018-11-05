<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Foundation</title>
<link rel="stylesheet" href="css/estilo-lista.css" />
</head>
<body>

	<%@ page import="br.com.flf.jdbc.LivroDAO"%>
	<%@ page import="br.com.flf.models.Livro"%>
	<%@ page import="java.util.List"%>
	


	<%
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.getLista();
	%>

	<div id="menu">
		<ol>
		
			<li><a href="alterar-livro.html">Alterar</a></li>
			<li><a href="remover-livro.html">Remover</a></li>
			<li><a href="listar-livros.jsp">Listar</a></li>
			<li><a href="pesquisar-livro.jsp">Pesquisar</a></li>
			<li><a href="adiciona-livro.html">Adiciona</a></li>
		</ol>
	</div>

	<h2 id="lLivros">Lista de Livros</h2>

	<table>
		<tr>
			<td id="pt1">Título</td>
			<td id="pt1">Autores</td>
			<td id="pt1">Gênero</td>
			<td id="pt1">Ano</td>
			<td id="pt1">Editora</td>
		</tr>
		<%
			for (Livro livro : livros) {
		%>

		<tr>
			<td><%=livro.getTitulo()%></td>
			<td><%=livro.getAutores()%></td>
			<td><%=livro.getGenero()%></td>
			<td><%=livro.getAno()%></td>
			<td><%=livro.getEditora()%></td>
		</tr>

		<%
			}
		%>
		
	</table>

</body>
</html>