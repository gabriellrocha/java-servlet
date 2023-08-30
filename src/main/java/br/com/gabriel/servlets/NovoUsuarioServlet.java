package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.entidades.Usuario;
import br.com.gabriel.infra.Banco;

@WebServlet({ "/novoUsuario", "/novoUsuarioServlet"})
public class NovoUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final Banco bancoDB = Banco.criarBancoDados();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("dataNascimento");
		
		Usuario newUsuario = new Usuario(1L, nome, null, data);
		
		bancoDB.cadastrarUsuario(newUsuario);
		
		// Chama o JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("novoUsuario.jsp");
		
		// Agrupa o nome do usuario no request que será passado para o JSP
		request.setAttribute("nomeUsuario", newUsuario.getNome());
		request.setAttribute("dataNascimento", newUsuario.getDataNascimento());
		
		dispatcher.forward(request, response);
		
		/* Exemplo de fluxo:
		 * 
		 * Cliente faz requisição HTTP ->
		 * TomCat -> Passa para o Servlet devidamente mapeado ->
		 * Servlet faz o processamento, neste caso cadastra no banco de dados ->
		 * Servlet chama o JSP ->
		 * JSP -> Faz o trabalho de resposta(gerando o HTML) dinâmico*
		 */
	
	}	
}
