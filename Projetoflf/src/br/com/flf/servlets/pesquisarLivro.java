package br.com.flf.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.LivroDAO;
import br.com.flf.models.Livro;

@WebServlet("/pesquisarLivro")
public class pesquisarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public pesquisarLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String pesquisa = request.getParameter("key");
		LivroDAO pesquisadao = new LivroDAO();
		List<Livro> result = new ArrayList<Livro>();
		try {
			result = pesquisadao.getPesquisa(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lista_req", result);
		RequestDispatcher disp = request.getRequestDispatcher("pesquisa-livro.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
