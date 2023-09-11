package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;
import br.com.gabriel.modelo.infra.Banco;

@WebServlet(urlPatterns = {"/usuarios"})
public class ServletApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final Banco bancoDB = Banco.criarBancoDados();
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathJSP = null;
		String action = request.getParameter("action");
		
		// nome qualificado da classe
		String nomeClasse = "br.com.gabriel.acao." + action.substring(0, 1).toUpperCase() + action.substring(1);
		
		try {
			Class classe = Class.forName(nomeClasse);
			Action obj = (Action) classe.newInstance();
			pathJSP = obj.executar(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
				
		String[] tipoEEndereco = pathJSP.split(":");
		
		/* Se o prefixo for "forward" dispacha para o jsp, do contrário o cliente(navegador)
		 * faz o redirect
		 * */
		
		if(tipoEEndereco[0].equals("forward")) {
			// jsp devolve uma resposta para o navegador
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			dispatcher.forward(request, response);
			
		} else {
			// Navegador faz uma outra requisição pro endereço informado
			response.sendRedirect(tipoEEndereco[1]);
		}
	}	
}
