package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.models.Livro;
import br.com.flf.jdbc.LivroDAO;

@WebServlet("/adicionaLivro")
public class adicionaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public adicionaLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String titulo = request.getParameter("titulo");
		String autores = request.getParameter("autores");
		String genero = request.getParameter("genero");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String editora = request.getParameter("editora");
		
		Livro livro = new Livro(); 
		livro.setTitulo(titulo);
		livro.setAutores(autores);
		livro.setGenero(genero);
		livro.setAno(ano); 
		livro.setEditora(editora); 
		
		LivroDAO bookdao = new LivroDAO();
		try {
			bookdao.adiciona(livro);
			 out.println("<html>");
	         out.println("<body>");
	         out.println("Livro: \"" + livro.getTitulo() + "\",adicionado!");
	         out.println("</body>");
	         out.println("</html>");
		     }catch (Exception e) {
		            out.print(e);
		            e.printStackTrace();
		        }
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
