package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.Atualizar;
import br.com.gabriel.acao.Criar;
import br.com.gabriel.acao.Excluir;
import br.com.gabriel.acao.Exibir;
import br.com.gabriel.acao.Listar;
import br.com.gabriel.modelo.infra.Banco;

@WebServlet(urlPatterns = {"/usuarios"})
public class ServletApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final Banco bancoDB = Banco.criarBancoDados();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String retorno = null;
		String action = request.getParameter("action");
		
		if(action.equals("criar")) {
						
			Criar obj = new Criar();
			retorno = obj.executar(request, response);
			
			
		} else if (action.equals("listar")) {	
			
			Listar obj = new Listar();
			retorno = obj.executa(request, response);
			
		} else if (action.equals("excluir")) {
			
			Excluir obj = new Excluir();
			retorno = obj.executar(request, response);
			
		} else if (action.equals("exibir")) {
			
			Exibir obj = new Exibir();
			retorno = obj.executa(request, response);
			
		} else if (action.equals("atualizar")) {
			
			Atualizar obj = new Atualizar();
			retorno = obj.executar(request, response);
			
		}
		
		String[] tipoEEndereco = retorno.split(":");
		
		/* Se o prefixo for "forward" dispacha para o jsp, do contrário o cliente(navegador)
		 * faz o redirect
		 * */
		
		if(tipoEEndereco[0].equals("forward")) {
			// jsp devolve uma resposta para o navegador
			RequestDispatcher dispatcher = request.getRequestDispatcher(tipoEEndereco[1]);
			dispatcher.forward(request, response);
			
		} else {
			// Navegador faz uma outra requisição pro endereço informado
			response.sendRedirect(tipoEEndereco[1]);
		}
	}	
}
